package com.mall.shiro;

import com.mall.entity.MallPermission;
import com.mall.entity.MallRole;
import com.mall.entity.User;
import com.mall.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 负责授权和认证规则的建立
 *
 * @author 夏有乔木，雅望天堂
 * @date 2023/02/19
 */
// @Component
public class MallRealm extends AuthorizingRealm {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 获取授权信息：进行授权工作
     *
     * @param authenticationToken 身份验证令牌
     * @return {@link AuthenticationInfo}
     * @throws AuthenticationException 身份验证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 获取用户传递的用户名
        String username = token.getUsername();
        // 获取用户传递的密码
        char[] password = token.getPassword();
        // 验证账户是否存在
        User user = userService.login(username);
        if (user == null) {
            // 返回null，代表用户不存在,认证失败则抛出 AuthenticationException
            return null;
        } else if (!user.getUserPassword().equals(String.valueOf(password))) {
            // 对密码进行验证
            return null;
        }

        /*
          SimpleAuthenticationInfo 简单认证信息,
          参数一:用户对象或者用户名
          参数二:用户密码
          参数三:即当前realm的名称。
          realm获取用户信息的桥梁
         */
        // 保存session
        Subject subject = SecurityUtils.getSubject();
        // subject.
        subject.getSession().setAttribute("User", user);
        return new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
    }

    /**
     * 获取认证信息：进行认证工作
     *
     * @param principalCollection 身份
     * @return {@link AuthorizationInfo}
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 获取一个可用的用户身份，取决于SimpleAuthenticationInfo的第一个参数
        User availablePrincipal = (User) super.getAvailablePrincipal(principalCollection);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<MallRole> rolesName = userService.getRolesByUserName(availablePrincipal.getUserName());

        // 获取用户对应的角色
        List<String> rolesNameList = rolesName.stream().map(MallRole::getMallRoleName)
                .collect(Collectors.toList());
        System.out.println("rolesNameList = " + rolesNameList);
        // 获取角色对应的权限
        List<String> permissionNameList = rolesName.stream()
                .flatMap(s -> s.getMallPermissionList().stream())
                .map(MallPermission::getMallPermissionName)
                .distinct()
                .collect(Collectors.toList());
        // 给用户分配角色
        info.addRoles(rolesNameList);
        // 给角色分配权限
        info.addStringPermissions(permissionNameList);
        return info;
    }
}
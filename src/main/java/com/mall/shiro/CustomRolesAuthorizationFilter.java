// package com.mall.shiro;
//
// import org.apache.shiro.subject.Subject;
// import org.apache.shiro.web.filter.authz.AuthorizationFilter;
//
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
//
// /**
//  * 自定义角色授权过滤器
//  * AuthorizationFilter抽象类事项了javax.servlet.Filter接口，它是个过滤器。
//  * @author 夏有乔木，雅望天堂
//  * @date 2023/02/20
//  */
// public class CustomRolesAuthorizationFilter extends AuthorizationFilter {
//
//     @Override
//     protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
//         Subject subject = getSubject(req, resp);
//         String[] rolesArray = (String[]) mappedValue;
//
//         if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问
//             return true;
//         }
//         for (String s : rolesArray) {
//             if (subject.hasRole(s)) { //若当前用户是rolesArray中的任何一个，则有权限访问
//                 return true;
//             }
//         }
//         return false;
//     }
// }
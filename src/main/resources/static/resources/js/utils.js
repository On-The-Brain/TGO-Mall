/**
 * 格式化函数 ， 给日期格式化
 * date为 new Date()对象， fmt为 'yyyy-MM-dd hh:mm:ss'的格式
 */
function formatDate(date, fmt) {
    //获取年份
    if (/(y+)/.test(fmt)) {
        // 把数字变成字符串
        let dateY = date.getFullYear() + "";
        //RegExp.$1 在判断中出现过，且是括号括起来的，所以 RegExp.$1 就是 "yyyy"
        fmt = fmt.replace(RegExp.$1, dateY.substr(4 - RegExp.$1.length));
    }

    //获取其他
    let o = {
        "M+": date.getMonth() + 1,
        "d+": date.getDate(),
        "h+": date.getHours(),
        "m+": date.getMinutes(),
        "s+": date.getSeconds(),
    };
    for (const k in o) {
        if (new RegExp(`(${k})`).test(fmt)) {
            let str = o[k] + "";
            fmt = fmt.replace(
                RegExp.$1,
                RegExp.$1.length == 1 ? str : padLeftZero(str)
            );
        }
    }
    return fmt;
}

function padLeftZero(str) {
    return ("00" + str).substr(str.length);
}

var p1 = ChineseDistricts[86]['A-G'];
var p2 = ChineseDistricts[86]['H-K'];
var p3 = ChineseDistricts[86]['L-S'];
var p4 = ChineseDistricts[86]['T-Z'];

function getAddressByProvinceCode(provinceCode, p) {
    var province = '';
    for (var i = 0; i < p.length; i++) {
        if (provinceCode == p[i].code) {
            province = p[i].address;
            break;
        }
    }
    return province;
}

function getByDistrict(districtCode) {
    var province = '';
    var city = '';
    var district = '';
    try {
        var provinceCode = parseInt(districtCode / 10000) * 10000;
        var cityCode = parseInt(districtCode / 100) * 100;
        city = ChineseDistricts[provinceCode][cityCode];
        district = ChineseDistricts[cityCode][districtCode];
        var isFound = 0;
        if (isFound == 0) {
            province = getAddressByProvinceCode(provinceCode, p1);
            if (province != '') {
                isFound = 1;
            }
        }
        if (isFound == 0) {
            province = getAddressByProvinceCode(provinceCode, p2);
            if (province != '') {
                isFound = 1;
            }
        }
        if (isFound == 0) {
            province = getAddressByProvinceCode(provinceCode, p3);
            if (province != '') {
                isFound = 1;
            }
        }
        if (isFound == 0) {
            province = getAddressByProvinceCode(provinceCode, p4);
            if (province != '') {
                isFound = 1;
            }
        }
    } catch (err) {
        console.log(err);
    }

    var arr = new Array(3);
    arr[0] = province;
    arr[1] = city;
    arr[2] = district;
    return arr;
}

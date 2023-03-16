// //说明：
// //  1.如果加密解密涉及到前端和后端，则这里的key要保持和后端的key一致
// //  2.AES的算法模式有好几种（ECB,CBC,CFB,OFB），所以也要和后端保持一致
// //  3.AES的补码方式有两种（PKS5，PKS7），所以也要和后端保持一致
// //  4.AES的密钥长度有三种（128,192,256，默认是128），所以也要和后端保持一致
// //  5.AES的加密结果编码方式有两种（base64和十六进制），具体怎么选择由自己定，但是加密和解密的编码方式要统一
// var key = CryptoJS.enc.Utf8.parse("cBssbHB3ZA==HKXT");
// /*加密*/
// function aesEncode(str) {
//     var encryptedData = CryptoJS.AES.encrypt(str, key, {
//         mode: CryptoJS.mode.ECB,
//         padding: CryptoJS.pad.Pkcs7
//     });
//     return encryptedData.toString();
// }
//
// /*解密*/
// function aesDecode(encryptedStr) {
//     var encryptedHexStr  = CryptoJS.enc.Base64.parse(encryptedStr);
//     var encryptedBase64Str  = CryptoJS.enc.Base64.stringify(encryptedHexStr);
//     var decryptedData  = CryptoJS.AES.decrypt(encryptedBase64Str, key, {
//         mode: CryptoJS.mode.ECB,
//         padding: CryptoJS.pad.Pkcs7
//     });
//     return decryptedData.toString(CryptoJS.enc.Utf8);
// }

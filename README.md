# 工程简介

# 延伸阅读

//只返回200
ResponseEntity<ErrorResult> response = ResponseEntity.ok(null);

//返回具体错误
ErrorResult.builder().errCode("002").errMessage("验证码发送失败").build();
ResponseEntity<ErrorResult> response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResult);

//包含自定义响应头的
HttpHeaders headers = new HttpHeaders();
headers.add("Custom-Header", "foo");

    return new ResponseEntity<>(
      "Custom header set", headers, HttpStatus.OK);

//链式header,body赋值
ResponseEntity<String> customHeader() {
return ResponseEntity.ok()
.header("Custom-Header", "foo")
.body("Custom header set");
}


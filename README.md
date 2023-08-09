# HttpJsonResponder
一个轻量的JSON响应体库


* 仓库搭建完成，文档待完善。


# 快速入门

## 一、 AjaxResult 快速构建方法

AjaxResultBuilder.builder(HttpStatusCode httpStatusCode) - 根据状态码构建
AjaxResultBuilder.builder(HttpStatusCode httpStatusCode, Object data) - 根据状态码和数据本身构建

## 二、 MapResult 快速构建方法

HashMapResultBuilder builder(HttpStatusCode httpStatusCode) - 根据状态码构建
HashMapResultBuilder builder() - 获取空构建器


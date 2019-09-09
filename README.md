## AMap API - 高德地图无限调用后端

#### 基本思路
- 高德的后端Restful接口限制频率和次数
- 高德的前端SDK不限制接口调用频率和次数
- 把前端转成后端的数据来源，以此无限调用API

#### 实现逻辑
- 写一个高德地图的前端（此处直接使用了模板）
- 写一个JS的函数调用，使用HtmlUnit运行
- "我爬我自己"，得到返回值
- 在Java中，将JS的异步回调，改为同步(以Java的多线程，代替JS的单线程)
- 得到数据

#### 支持接口
- [路径规划接口文档](doc/Route-API.md)
- [地理编码接口文档](doc/Geocode-API.md)
- [搜索接口文档](doc/Search-API.md)
- 注：此文档中X值为经度，Y值为纬度

#### 配置
- 仅 "amap.api.key" 必填, 更改为你申请的高德 JS版本SDK 的APIKey

#### 部署
- mvn clean package
- 使用得到的Jar包进行部署
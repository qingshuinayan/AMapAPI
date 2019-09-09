## 路径规划接口

#### /route/driver 行车路径规划 GET
| 名称 | 描述 | 类型 | 必选 | 默认值 | 允许值 | 
| :---: | :---: | :---: | :---: | :---: | :---: |
| sX | 起点X值 | double | 是 | / | -180.0 ~ 180.0 |
| sY | 起点Y值 | double | 是 | / | -90.0 ~ 90.0 |
| eX | 终点X值 | double | 是 | / | -180.0 ~ 180.0 |
| eY | 终点Y值 | double | 是 | / | -90.0 ~ 90.0 |
| policy | 策略 | string | 是 | / | LEAST_TIME, LEAST_FEE, LEAST_DISTANCE, REAL_TRAFFIC |

| 策略名 | 描述 |
| :---: | :---: |
| LEAST_TIME | 时间最短 |
| LEAST_FEE | 费用最少 |
| LEAST_DISTANCE | 距离最短 |
| REAL_TRAFFIC | 考虑实时路径 |

#### /route/bus 公共交通路径规划 GET
| 名称 | 描述 | 类型 | 必选 | 默认值 | 允许值 | 
| :---: | :---: | :---: | :---: | :---: | :---: |
| sX | 起点X值 | double | 是 | / | -180.0 ~ 180.0 |
| sY | 起点Y值 | double | 是 | / | -90.0 ~ 90.0 |
| eX | 终点X值 | double | 是 | / | -180.0 ~ 180.0 |
| eY | 终点Y值 | double | 是 | / | -90.0 ~ 90.0 |
| policy | 策略 | string | 是 | / | LEAST_TIME, LEAST_FEE, LEAST_TRANSFER, MOST_COMFORT, NO_SUBWAY, LEAST_WALK |

| 策略名 | 描述 |
| :---: | :---: |
| LEAST_TIME | 时间最短 |
| LEAST_FEE | 费用最少 |
| LEAST_TRANSFER | 最少换乘 |
| MOST_COMFORT | 最舒适 |
| NO_SUBWAY | 不坐地铁 |
| LEAST_WALK | 最少步行 |

#### /route/walk 步行路径规划 GET
| 名称 | 描述 | 类型 | 必选 | 默认值 | 允许值 | 
| :---: | :---: | :---: | :---: | :---: | :---: |
| sX | 起点X值 | double | 是 | / | -180.0 ~ 180.0 |
| sY | 起点Y值 | double | 是 | / | -90.0 ~ 90.0 |
| eX | 终点X值 | double | 是 | / | -180.0 ~ 180.0 |
| eY | 终点Y值 | double | 是 | / | -90.0 ~ 90.0 |

#### /route/ride 骑行路径规划 GET
| 名称 | 描述 | 类型 | 必选 | 默认值 | 允许值 | 
| :---: | :---: | :---: | :---: | :---: | :---: |
| sX | 起点X值 | double | 是 | / | -180.0 ~ 180.0 |
| sY | 起点Y值 | double | 是 | / | -90.0 ~ 90.0 |
| eX | 终点X值 | double | 是 | / | -180.0 ~ 180.0 |
| eY | 终点Y值 | double | 是 | / | -90.0 ~ 90.0 |

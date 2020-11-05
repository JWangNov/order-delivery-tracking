# Setup MongoDB

|     Item      |         Value         |
| :-----------: | :-------------------: |
|     Host      |       localhost       |
|     Port      |         27017         |
|     User      | n/a (root by default) |
|      DB       |     ordertracking     |
| Collection(s) |         order         |



```mongojs
use ordertracking

db.createCollection("order")
```
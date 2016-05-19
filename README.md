# 教务系统后端接口
## /upload
[POST]
```html
<input type='file' name='name' accept-encoding='utf-8' />
```
return
```json
{message:'上传成功',code:0}
```
====
## /download
[GET]
```url
/download/aaaa.html
aaaa.html是文件名
```
return 文件流

====
## /filelist
[GET]

return
```json
[{id:{bson},date:Time,filename:String,uuid:String}]
```
===
## /image
[GET]
```url
/image/x
x是uuid
```
return 文件流

===
## /notice
[GET]

return
```json
{id:id,image:image.uuid}
```
===
## notice
[POST]
```html
<input name='title' />
<input name='content' />
<input type='file' name='file' />
```
return
```json
{message:'创建通知成功',code:0}
```
===
## /notice/view
[GET]
```url
/notice/view/:uid
```
return
```json
{id:id,date:Time,title:String,content:String}
```
===
## /schedule
[POST]
```html
<input name='classname' />
<input type='file' name='file' />
```
return
```json
{message:'上传成功',code:0}
```
===

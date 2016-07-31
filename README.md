# Android 学习项目
- 项目初衷,每天会阅读互联网上的技术文章,很多时候都是不做笔记或者只是简单摘抄几句重点,后来遇到了很多之前看到过的问题,再回过头去找笔记时发现自己都已经看不懂了。
- 好了,熟话说 Talk is cheap,show me the code ！
- 以后看到好的技术总结或者自己的思考,就归纳到这个仓库里面,方便自己查阅,也方便大家学习。

<a href="https://github.com/h4de5ing/AppDemo">代码</a>
<a href="https://github.com/h4de5ing/AppDemo/wiki">笔记</a>
## 扫描生成二维码
## 退出应用的方法
* 保存Activity实例在集合中,统一结束所有的Activity
* 通过广播退出应用
* 按2次返回按钮退出应用
* 长按返回按钮
* 通过退出按钮
```
进程是由os底层管理,所以少调用System.exit(0)和android.os.Process.killProcess(android.os.Process.myPid());
finish()：结束当前Activity，不会立即释放内存。遵循android内存管理机制。
exit()：结束当前组件如Activity，并立即释放当前Activity所占资源。
killProcess()：结束当前组件如Activity，并立即释放当前Activity所占资源。
restartPackage()：结束整个App，包括service等其它Activity组件。
```
## 第三方开源框架

工具类库:[AndroidCommon](https://github.com/h4de5ing/AndroidCommon)

二维码:[BGAQRCode-Android](https://github.com/bingoogolapple/BGAQRCode-Android)

圆形图片:[CircleImageView](https://github.com/hdodenhof/CircleImageView)
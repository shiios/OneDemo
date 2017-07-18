# OneDemo
此项目纯属个人练手之用！\n
将现有项目添加到远程github仓库：
1.创建仓库并复制仓库地址
2.初始化本地仓库，并提交内容到本地
touch README.md 
git init
git add .
git commit -m ""
3.链接到远程仓库，并同步代码到仓库
git remote add origin 远程仓库地址
git push -u origin master(如果报错：failed to push some refs to 'https://github.com/shiios/OneDemo.git'，主要是GitHub的README.md文件不在本地代码目录中，可以先进行代码合并git pull --rebase origin master)
4.添加并同步本地代码
git push
5.若多人开发，则需要按照格式书写
git pull 仓库别名 仓库分支名 
git push 仓库别名 仓库分支名

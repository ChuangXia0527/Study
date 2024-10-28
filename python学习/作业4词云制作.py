import matplotlib.pyplot as plt
import wordcloud
import jieba

mask1=plt.imread(r'D:\R.jpg')
mask2=plt.imread(r'D:\R.jpg')
f = open("F:\桌面\\2020政府工作报告.txt","r",encoding="utf-8",errors="ignore").read()
t = open("F:\桌面\习近平讲话.txt","r",encoding="gbk",errors="ignore").read()

txt1 = jieba.lcut(f)
txt2 = jieba.lcut(t)

fre={}
stopwords=['你','的','和','是','了','会','才','只']
for word in txt1:
    if word not in stopwords:
        fre[word]=fre.get(word,0)+1

for word in txt2:
    if word not in stopwords:
        fre[word]=fre.get(word,0)+1

sentence1 = ' '.join(txt1) #2020政府工作报告
sentence2 = ' '.join(txt2) #习近平讲话

#2020政府工作报告生成的词云
wc = wordcloud.WordCloud(
    font_path = r'C:\Windows\\Fonts\simhei.ttf',  # 设置中文字体路径
    mask=mask1,
    background_color="white",
    width=3274,
    height=2432,
    stopwords=stopwords
)

wc.generate(sentence1)#2020政府工作报告
wc.to_file("file1.png")#2020政府工作报告

#习近平讲话生成的词云
wc2 = wordcloud.WordCloud(
    font_path = r'C:\Windows\\Fonts\simhei.ttf',  # 设置中文字体路径
    mask=mask2,
    background_color="white",
    width=3274,
    height=2432,
    stopwords=stopwords
)

wc2.generate(sentence2)#习近平讲话
wc2.to_file("file2.png")#习近平讲话
package com.xiasuhuei321.gank_kotlin.datasource.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiasuhuei321 on 2016/11/21.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
@SuppressWarnings("unused")
public class TechBean implements Serializable {

    private static final long serialVersionUID = 6785163996418285465L;
    /**
     * error : false
     * results : [{"_id":"5831635d421aa929a8b2c50d","createdAt":"2016-11-20T16:48:29.396Z","desc":"MusicPlayerView","images":["http://img.gank.io/615fb19b-6519-4c75-9772-c18f649ef7c5"],"publishedAt":"2016-11-21T11:16:48.599Z","source":"chrome","type":"Android","url":"https://github.com/amineghabi/Material_MusicPlayerView","used":true,"who":"Jason"},{"_id":"5832571b421aa929b66fb0f9","createdAt":"2016-11-21T10:08:27.793Z","desc":"Android 两状态 或者 三状态 Switch 按钮，三状态切换超实用。","images":["http://img.gank.io/39f483ed-ba93-4e7b-b1ca-1781fd7951d7"],"publishedAt":"2016-11-21T11:16:48.599Z","source":"chrome","type":"Android","url":"https://github.com/RiccardoMoro/RMSwitch","used":true,"who":"daimajia"},{"_id":"5832582e421aa929a8b2c514","createdAt":"2016-11-21T10:13:02.493Z","desc":"轻量级 Android 导航系统（切换当前界面）（PS. 不是很好翻译，非常实用的项目）","images":["http://img.gank.io/744e5b2e-3484-4dfb-ad36-7ef2d8e81df1"],"publishedAt":"2016-11-21T11:16:48.599Z","source":"chrome","type":"Android","url":"https://github.com/terrakok/Cicerone","used":true,"who":"代码家"},{"_id":"582d81b2421aa95006efc062","createdAt":"2016-11-17T18:08:50.115Z","desc":"Android中事件传递分析","images":["http://img.gank.io/3b0b193d-6abf-4714-9d5a-5508404666f4"],"publishedAt":"2016-11-18T11:21:35.425Z","source":"web","type":"Android","url":"http://zjutkz.net/2016/11/17/Android%E4%B8%AD%E4%BA%8B%E4%BB%B6%E4%BC%A0%E9%80%92%E5%88%86%E6%9E%90","used":true,"who":null},{"_id":"582e4cd1421aa94ffc377a2a","createdAt":"2016-11-18T08:35:29.213Z","desc":"Android 实现的算法可是工具，随时随地帮助学习算法。","images":["http://img.gank.io/9b16a9e8-a755-4a9a-9a2a-dd4400e2696e"],"publishedAt":"2016-11-18T11:21:35.425Z","source":"chrome","type":"Android","url":"https://github.com/naman14/AlgorithmVisualizer-Android","used":true,"who":"代码家"},{"_id":"582e62f5421aa94ffa9f7643","createdAt":"2016-11-18T10:09:57.508Z","desc":"ENViews, 一个华丽丽的动效控件库","images":["http://img.gank.io/f38a88af-a15c-4a8d-8d85-1f9632f47952","http://img.gank.io/39fc9a70-c3e3-4d40-9f63-ee1d556b9c2b","http://img.gank.io/c5f02c75-94d6-4f5b-a9d5-79304852cdcb"],"publishedAt":"2016-11-18T11:21:35.425Z","source":"web","type":"Android","url":"https://github.com/codeestX/ENViews","used":true,"who":"Est"},{"_id":"582e6585421aa94ffc377a2e","createdAt":"2016-11-18T10:20:53.239Z","desc":"通过网页来查看 Android 本机数据库和 SharedPreference 数据。","images":["http://img.gank.io/29a00999-f560-4399-804d-6ee86df3d4f1"],"publishedAt":"2016-11-18T11:21:35.425Z","source":"chrome","type":"Android","url":"https://github.com/amitshekhariitbhu/Android-Debug-Database","used":true,"who":"代码家"},{"_id":"582e66ef421aa94ffc377a30","createdAt":"2016-11-18T10:26:55.858Z","desc":"Badge 风格的 TextView，支持 Shadow 和 Elevation。","images":["http://img.gank.io/7d8e50ab-3885-4554-be7f-de155af23fe1"],"publishedAt":"2016-11-18T11:21:35.425Z","source":"chrome","type":"Android","url":"https://github.com/matrixxun/MaterialBadgeTextView","used":true,"who":"代码家"},{"_id":"582e6771421aa94ffa9f7646","createdAt":"2016-11-18T10:29:05.759Z","desc":"轻轻松松使用 Android 自定义字体","images":["http://img.gank.io/0116d93b-33c5-4ec1-a8d5-98b609f95f54"],"publishedAt":"2016-11-18T11:21:35.425Z","source":"chrome","type":"Android","url":"https://github.com/smart-fun/SmartFonts","used":true,"who":"代码家"},{"_id":"582ab455421aa9198ccf9c7e","createdAt":"2016-11-15T15:08:05.238Z","desc":"Android social login (facebook, google) helper powered by RxJava ","publishedAt":"2016-11-17T11:32:04.807Z","source":"web","type":"Android","url":"https://github.com/jaychang0917/SocialLoginManager","used":true,"who":"Jay"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Serializable {
        private static final long serialVersionUID = -7660834886828873918L;

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;
        /**
         * 是否被收藏，0未被收藏，1被收藏且上传至服务器，2本地收藏，服务器未同步。
         */
        private int collectStatus = 0;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getCollectStatus() {
            return collectStatus;
        }

        public void setCollectStatus(int collectStatus) {
            this.collectStatus = collectStatus;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[id]  ").append(_id).append("\n")
                    .append("[createdAt]  ").append(createdAt).append("\n")
                    .append("[desc]  ").append(desc).append("\n")
                    .append("[publicedAt]  ").append(publishedAt).append("\n")
                    .append("[source]  ").append(source).append("\n")
                    .append("[type]  ").append(type).append("\n")
                    .append("[url]  ").append(url).append("\n")
                    .append("[who]  ").append(who).append("\n");
            if (images != null) {
                for (String s : images) {
                    sb.append("[images]  ").append(s).append("\n");
                }
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ResultsBean))
                return false;
            if (((ResultsBean) obj).get_id().equals(this.get_id()))
                return true;
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "error-->" + error;
    }
}

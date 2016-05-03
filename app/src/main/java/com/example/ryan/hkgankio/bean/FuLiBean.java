package com.example.ryan.hkgankio.bean;

import java.util.List;

/**
 * Created by studio02 on 5/3/16.
 */
public class FuLiBean {


    /**
     * error : false
     * results : [{"_id":"5722b27b67765974fbfcf9b9","createdAt":"2016-04-29T09:01:47.962Z","desc":"4.29","publishedAt":"2016-04-29T11:36:42.906Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1f3damign7mj211c0l0dj2.jpg","used":true,"who":"张涵宇"},{"_id":"5721791f67765974fbfcf9a8","createdAt":"2016-04-28T10:44:47.43Z","desc":"4.28","publishedAt":"2016-04-28T13:07:51.7Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1f3c7zc3y3rj20rt15odmp.jpg","used":true,"who":"张涵宇"},{"_id":"5720107467765974f885bf9f","createdAt":"2016-04-27T09:05:56.10Z","desc":"4.27","publishedAt":"2016-04-27T12:04:15.19Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1f3azi5zoysj20dw0kuabb.jpg","used":true,"who":"张涵宇"},{"_id":"571ec86667765974fbfcf97b","createdAt":"2016-04-26T09:46:14.929Z","desc":"4.26","publishedAt":"2016-04-26T11:58:55.460Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f39v1uljz8j20c50hst9q.jpg","used":true,"who":"张涵宇"},{"_id":"571c841e67765974f885bf73","createdAt":"2016-04-24T16:30:22.634Z","desc":"4.25","publishedAt":"2016-04-25T11:24:01.704Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f37vhovzlnj20f00evabt.jpg","used":true,"who":"张涵宇"},{"_id":"5719a5e267765974fbfcf94e","createdAt":"2016-04-22T12:17:38.977Z","desc":"4.22","publishedAt":"2016-04-22T12:18:52.507Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1f35cxyferej20dw0i2789.jpg","used":true,"who":"代码家"},{"_id":"57181bb567765974fca83045","createdAt":"2016-04-21T08:15:49.254Z","desc":"4.21","publishedAt":"2016-04-21T11:41:00.247Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1f340c8jrk4j20j60srgpf.jpg","used":true,"who":"张涵宇"},{"_id":"57163a9c67765974f5e27dbd","createdAt":"2016-04-19T22:03:08.319Z","desc":"4.20","publishedAt":"2016-04-20T11:46:37.909Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f32d0cumhkj20ey0mitbx.jpg","used":true,"who":"张涵宇"},{"_id":"5714700267765974f885bf16","createdAt":"2016-04-18T13:26:26.590Z","desc":"4.19","publishedAt":"2016-04-19T12:13:58.869Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1f30sgi3jf0j20iz0sg40a.jpg","used":true,"who":"张涵宇"},{"_id":"57136f0e67765974f885bf10","createdAt":"2016-04-17T19:10:06.853Z","desc":"4.18","publishedAt":"2016-04-18T12:05:28.120Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1f2zwrqkmwoj20f00lg0v7.jpg","used":true,"who":"张涵宇"}]
     */

    private boolean error;
    /**
     * _id : 5722b27b67765974fbfcf9b9
     * createdAt : 2016-04-29T09:01:47.962Z
     * desc : 4.29
     * publishedAt : 2016-04-29T11:36:42.906Z
     * source : chrome
     * type : 福利
     * url : http://ww1.sinaimg.cn/large/7a8aed7bgw1f3damign7mj211c0l0dj2.jpg
     * used : true
     * who : 张涵宇
     */

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

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

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
    }
}

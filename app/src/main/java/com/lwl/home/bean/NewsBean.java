package com.lwl.home.bean;

import java.util.List;

/**
 * Created by uk on 2017/4/7.
 */

public class NewsBean {

    /**
     * postid : CHEFTDVI0001875O
     * url_3w : http://news.163.com/17/0407/17/CHEFTDVI0001875O.html
     * votecount : 119504
     * replyCount : 123083
     * ltitle : 华裔女富二代谋杀前男友并拒捕 母亲交5亿保释金
     * digest : 震惊！中国富二代女在美谋杀前男友，母亲从中国赶来交5亿天价保释金！拒捕，警方曾动用装甲车去年5月，旧金山湾区（TheBayArea）发生了一起华人谋杀凶案，轰动
     * url : http://3g.163.com/news/17/0407/17/CHEFTDVI0001875O.html
     * docid : CHEFTDVI0001875O
     * title : 华裔女富二代谋杀前男友并拒捕 母亲交5亿保释金
     * source : 中国青年网
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/c53ef4c8915341198f5c6cece1bf476720170407172149.png"},{"imgsrc":"http://cms-bucket.nosdn.127.net/e7f5991196a94f2b8cfbbea4ff4847f620170407172149.png"}]
     * priority : 130
     * lmodify : 2017-04-07 20:01:07
     * imgsrc : http://cms-bucket.nosdn.127.net/6cfcb9df5af94279826c97fc07a8ae8a20170407172149.png
     * subtitle :
     * boardid : news_guoji2_bbs
     * ptime : 2017-04-07 17:22:06
     */

    private String postid;
    private String url_3w;
    private int votecount;
    private int replyCount;
    private String ltitle;
    private String digest;
    private String url;
    private String docid;
    private String title;
    private String source;
    private int priority;
    private String lmodify;
    private String imgsrc;
    private String subtitle;
    private String boardid;
    private String ptime;
    private List<ImgextraBean> imgextra;

    private int type;

    public int getType() {
        if (imgextra.size() == 0) {
            return 1;
        }else{
            return 2;
        }
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUrl_3w() {
        return url_3w;
    }

    public void setUrl_3w(String url_3w) {
        this.url_3w = url_3w;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getReplyCount() {
       int tenTh = replyCount /10000; //万位
        int thou = replyCount%10000/1000; //千位
        if (tenTh > 0 ) {
            return String.format("%d.%d万跟帖", tenTh,thou);
        }
        return replyCount+"跟帖";
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    public static class ImgextraBean {
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/c53ef4c8915341198f5c6cece1bf476720170407172149.png
         */

        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}

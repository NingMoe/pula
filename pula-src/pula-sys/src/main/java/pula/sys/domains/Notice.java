/**
 * 
 */
package pula.sys.domains;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import puerta.support.annotation.WxlDomain;
import puerta.support.dao.LoggablePo;
import pula.sys.intfs.RefIdSupport;

/**
 * @author Liangfei
 *
 */
@WxlDomain("活动通知")
public class Notice implements LoggablePo, RefIdSupport {

    @JsonIgnore
    private static final ObjectMapper om = new ObjectMapper();

    @Override
    public String toLogString() {
        try {
            return om.writeValueAsString(this);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("[Notice: ");
            sb.append("noticeId=").append(id).append("title=").append(title);
            sb.append("]");
            return sb.toString();
        }
    }

    @JsonProperty
    private Long id;
    @JsonProperty
    private String no;
    @JsonProperty
    private String title;
    @JsonProperty
    private String formattedTitle;
    @JsonProperty
    private String content;
    @JsonProperty
    private String imgPath;
    @JsonProperty
    private String suffix;
    @JsonProperty
    private Date createTime;
    @JsonProperty
    private Date updateTime;
    @JsonProperty
    private String comment;

    @JsonProperty
    private boolean removed;
    @JsonProperty
    private boolean enabled;

    @JsonProperty
    private String creator;
    @JsonProperty
    private String updator;
    
    @JsonProperty
    private int noticePrice;
    @JsonProperty
    private int noticeCount;
    @JsonProperty
    private String noticeCourseNo = "";
    @JsonProperty
    private String noticeCourseName = "";
    @JsonProperty
    private String attachmentKey = "";
    
    public Notice() {
    }
    
    public Notice(Notice n) {
        this.id = n.id;
        this.no = n.no;
        this.title = n.title;
        this.formattedTitle = n.formattedTitle;
        this.content = n.content;
        this.imgPath = n.imgPath;
        this.suffix = n.suffix;
        this.createTime = n.createTime;
        this.updateTime = n.updateTime;
        this.comment = n.comment;
        this.removed = n.removed;
        this.enabled = n.enabled;
        this.creator = n.creator;
        this.updator = n.updator;
        this.noticePrice = n.noticePrice;
        this.noticeCount = n.noticeCount;
        this.noticeCourseNo = n.noticeCourseNo;
        this.noticeCourseName = n.noticeCourseName;
        this.attachmentKey = n.attachmentKey;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormattedTitle() {
        return formattedTitle;
    }

    public void setFormattedTitle(String formattedTitle) {
        this.formattedTitle = formattedTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getNoticePrice() {
        return noticePrice;
    }

    public void setNoticePrice(int noticePrice) {
        this.noticePrice = noticePrice;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public String getNoticeCourseNo() {
        return noticeCourseNo;
    }

    public void setNoticeCourseNo(String noticeCourseNo) {
        this.noticeCourseNo = noticeCourseNo;
    }

    public String getNoticeCourseName() {
        return noticeCourseName;
    }

    public void setNoticeCourseName(String noticeCourseName) {
        this.noticeCourseName = noticeCourseName;
    }

    public String getAttachmentKey() {
        return attachmentKey;
    }

    public void setAttachmentKey(String attachmentKey) {
        this.attachmentKey = attachmentKey;
    }

    @Override
    public String toRefId() {
        return CourseTaskResultWork.buildRefId(id, attachmentKey);
    }

    @Override
    public int getTypeRange() {
        return FileAttachment.TYPE_NOTICE_ICON;
    }

}

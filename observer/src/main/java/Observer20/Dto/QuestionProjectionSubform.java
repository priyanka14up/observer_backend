
package Observer20.Dto;


public class QuestionProjectionSubform {
  
    
    private Long qid;
    private String qtext;
    private String type;
    private Long fid;
    private Long sid;
    private String SHeading;

    public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getQtext() {
		return qtext;
	}

	public void setQtext(String qtext) {
		this.qtext = qtext;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}
	

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSHeading() {
		return SHeading;
	}

	public void setSHeading(String sHeading) {
		SHeading = sHeading;
	}

	public QuestionProjectionSubform(Long qid, String qtext, String type, Long fid, Long sid, String sHeading) {
		super();
		this.qid = qid;
		this.qtext = qtext;
		this.type = type;
		this.fid = fid;
		this.sid = sid;
		SHeading = sHeading;
	}

	

	
}
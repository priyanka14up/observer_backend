package Observer20.Dto;


public class QuestionProjection {
  
    
    private Long qid;
    private String qtext;
    private String type;
    private Long fid;

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

	public QuestionProjection(Long qid, String qtext, String type, Long fid) {
		super();
		this.qid = qid;
		this.qtext = qtext;
		this.type = type;
		this.fid = fid;
	}

	
}
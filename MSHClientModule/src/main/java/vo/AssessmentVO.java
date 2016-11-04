package vo;

/**
 * Created by Sorumi on 16/10/12.
 */
public class AssessmentVO {

    /**
     * 服务评分
     */
    public int serviceScore;

    /**
     * 设施评分
     */
    public int facilityScore;

    /**
     * 卫生评分
     */
    public int healthScore;

    /**
     * 位置评分
     */
    public int locationScore;

    /**
     * 评价
     */
    public String comment;

    public AssessmentVO(int serviceScore, int facilityScore, int healthScore, int locationScore, String comment) {
        this.serviceScore = serviceScore;
        this.facilityScore = facilityScore;
        this.healthScore = healthScore;
        this.locationScore = locationScore;

        this.comment = comment;
    }

}
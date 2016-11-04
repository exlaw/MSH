package po;

/**
 * Created by Sorumi on 16/11/1.
 */
public class AssessmentPO {

    private String orderID;

    /**
     * 服务评分
     */
    private int serviceScore;

    /**
     * 设施评分
     */
    private int facilityScore;

    /**
     * 卫生评分
     */
    private int healthScore;

    /**
     * 位置评分
     */
    private int locationScore;

    /**
     * 评价
     */
    private String comment;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getFacilityScore() {
        return facilityScore;
    }

    public void setFacilityScore(int facilityScore) {
        this.facilityScore = facilityScore;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(int healthScore) {
        this.healthScore = healthScore;
    }

    public int getLocationScore() {
        return locationScore;
    }

    public void setLocationScore(int locationScore) {
        this.locationScore = locationScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
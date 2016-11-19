package vo;

import util.DateUtil;
import util.PromotionType;

import static util.EqualJudgeHelper.judgeEqual;

/**
 * Created by Kray on 2016/10/12.
 */
public class Promotion_HotelVO extends PromotionVO{



    public Promotion_HotelVO(String promotionID, PromotionType promotionType, double promotionDiscount) {
        super(promotionID, promotionType, promotionDiscount);
    }

    public boolean equals(Object o){
        if (o instanceof Promotion_HotelVO) {
            Promotion_HotelVO promotionHotelVO = (Promotion_HotelVO) o;
            return compareData(promotionHotelVO);
        }
        return false;
    }

    public int hashCode() {
        return promotionID.hashCode();
    }

    private boolean compareData(Promotion_HotelVO pvo) {
        return judgeEqual(pvo.promotionID, this.promotionID)
                && judgeEqual(pvo.promotionType, this.promotionType)
                && judgeEqual(pvo.promotionDiscount,this.promotionDiscount);
    }
}

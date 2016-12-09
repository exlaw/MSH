package bl.orderbl;

import bl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLInfo;
import util.DateUtil;
import util.Place;
import vo.BillVO;
import vo.PromotionVO;

/**
 * Created by Sorumi on 16/11/1.
 */
public class Bill {

    private PromotionBLInfo promotionBLInfo;

    public Bill() {
        promotionBLInfo = new BLFactoryImpl().getPromotionBLInfo();
    }


    /**
     * 更新账单日期
     *
     * @param hotelID
     * @param date
     * @param birthday
     * @param enterpriseName
     * @param roomQuantity
     * @return
     */
    public BillVO refresh(String hotelID, Place place, DateUtil date, int clentGrade,
                          DateUtil birthday, String enterpriseName, int roomQuantity) {
//        return null;
        PromotionVO hotelPromotion = promotionBLInfo.getMinHotelProm(hotelID, date, birthday, enterpriseName, roomQuantity);
        PromotionVO websitePromotion = promotionBLInfo.getMinWebProm(date, clentGrade, place);
        return new BillVO(websitePromotion, hotelPromotion, 0, 0);
    }
}

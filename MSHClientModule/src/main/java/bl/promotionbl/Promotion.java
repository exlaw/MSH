package bl.promotionbl;

import dataservice.promotiondataservice.PromotionDataService;
import dataservice.promotiondataservice.PromotionDataService_Stub;
import util.PromotionType;
import util.ResultMessage;
import vo.Promotion_HotelVO;
import vo.Promotion_WebVO;


import java.util.ArrayList;

/**
 * Created by vivian on 16/11/2.
 */
public class Promotion {
    private PromotionDataService promotionDataService = new PromotionDataService_Stub();

    /**
     * 增加一个促销策略
     * @param promotionVO
     * @return 添加成功与否
     */
    public ResultMessage add(Promotion_HotelVO promotionVO){return null;}

    /**
     * 删除一个促销策略
     * @param promotionID
     * @return 删除成功与否
     */
    public ResultMessage delete(String promotionID){
        return promotionDataService.deletePromotion(promotionID);
    }

    /**
     * 更新一个促销策略
     * @param promotionID
     * @param promotionVO
     * @return 更新成功与否
     */
    public ResultMessage update(String promotionID , Promotion_HotelVO promotionVO){

        return null;
    }

    /**
     * 精确查找某个策略
     * @param promotionID
     * @return 符合条件的策略VO
     */
    public Promotion_HotelVO searchByID(String promotionID) {
        return null;
    }

    /**
     * 搜索某一类型的所有策略
     * @param promotionType
     * @return 符合条件的策略VO的列表
     */
    public ArrayList<Promotion_HotelVO> search(PromotionType promotionType){
        return null;
    }

    /**
     * 搜索某个酒店的所有促销策略
     * @param HotelID
     * @return 符合条件的策略VO的列表
     */
    public ArrayList<Promotion_HotelVO> searchHotelPromotions(String HotelID){
        return null;
    }

    /**
     * 搜索所有的网站促销策略
     * @return 符合条件的策略VO的列表
     */
    public ArrayList<Promotion_WebVO> searchWebPromotions(){
        return null;
    }

}

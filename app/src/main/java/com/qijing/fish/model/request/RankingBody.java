package com.qijing.fish.model.request;

/**
 * Created by czl on 2017/6/28.
 *  获取ranging 排行榜数据
 */

public class RankingBody extends BaseBody{

    public int type_win = 1;
    public int type_charm = 3 ;
    /**
             魅力排行天榜（APP调用）/ 赢钱排行天榜（App调用）( 唯一区别  d.a   )
             请求：{"e":"php.money.direct", "q":"php_money","d":{"k":"token","c":"money","a":"charm_day_top"}}
             e : 交换器，固定填 php.money.direct
             q : 路由, 固定填 php_money
             d.k : 用户token
             d.a : 接口名，固定填 charm_day_top     (魅力排行天榜)/////         d.a : 接口名，固定填 win_coin_day_top(赢钱排行天榜)
             d.c : 已废弃的可选参数，可以不填
             返回值：
             {"r":"0","p":[{"a":"user_id","b":"nickname","d":"head_img_url","s":"sex", "f":"level",
             "g":"score", "t":"charm", "r":"rank", "m":"fans_count", "n":"attentioned"},
             ..., {...}]}
             r : 原因值（0表示成功，其他为错误码）
             p : 排行榜列表 (第一条是用户自己的排名信息）
             p.a ：用户ID
             p.b ：昵称
             p.d ：头像
             p.f ：等级
             p.g ：积分
             p.t ：魅力值
             p.m ：粉丝数量
             p.n ：本用户是否关注了该用户 0/未关注 1/已关注
             p.s : 性别 0:男；1：女；2：其它
             p.r : 排名 （自己的排名若为0，表示不在榜内）
     *
     */
    @Override
    public BaseModuleRequset CreateBaseRequest() {
        BaseModuleRequset baseModuleRequset = new BaseModuleRequset();
        baseModuleRequset.eModel = "php.money.direct";
        baseModuleRequset.qModel = "php_money";
        baseModuleRequset.nModel = String.valueOf(baseModuleRequset.count++);
        return baseModuleRequset;
    }

    /**
     *          魅力排行天榜
     * @return
     */
    @Override
    public BaseModel CreateBaseModel() {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        baseModel.aParam = "charm_day_top";
        return baseModel;
    }

    /**
     *          赢钱排行天榜
     * @return
     */
    public BaseModel CreateWinModel(int type) {
        BaseModel baseModel = new BaseModel();
        baseModel.kParam = getToket();
        baseModel.cParam = "";
        if (type == type_charm) {
            baseModel.aParam = "charm_day_top";
        }else {
            baseModel.aParam = "win_coin_day_top";
        }

        return baseModel;
    }

    /**
     *         请求的实体类
     * @param baseBean
     * @return
     */
    @Override
    public BaseBean CreateBaseBean(BaseBean baseBean) {
        return baseBean;
    }

}

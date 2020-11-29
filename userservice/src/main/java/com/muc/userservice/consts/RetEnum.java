package com.muc.userservice.consts;

public enum RetEnum {
    SUCCESS(200,"success"),
    INTERNAL_ERROR(500, "内部异常"),
    VERIFY_APITOKEN_ERROR(10000, "apitoken不可用"),
    PARAMETER_EMPTY(10001, "参数不能为空"),
    PARAMETER_NOT_ALLOW(10002,"参数不正确"),
    TOKEN_VERIFY_FAIL(10003,"token认证失败"),

    THIRD_PARTY_BUSINESS_ERROR_CODE(299,"第三方信息错误码"),

    // community业务异常
    // 接口调用异常使用后缀为ERROR的错误码，其它异常找对应错误码（错误码根据BOCC接口返回做对应）
    // 使用方法如：ResultGenerator.genResult(RetEnum.COMMUNITY_MOMENT_PUBLISH_0001, null)

    COMMUNITY_FILE_UPLOAD_TYPE_ERROR(699121, "请求参数不完整/必填参数为空/参数格式不正确"),
    COMMUNITY_FILE_UPLOAD_ERROR(20001, "文件上传失败"),
    COMMUNITY_ARTICAL_LIST_ERROR(20002, "获取文章列表异常"),
    COMMUNITY_ARTICAL_DETAIL_ERROR(20003, "获取文章详情异常"),
    COMMUNITY_COMMENT_LIST_ERROR(20004, "获取评论列表异常"),
    COMMUNITY_FOLLOW_UNFOLLOW_ERROR(20005, "关注取消关注异常"),
    COMMUNITY_FOLLOW_UNFOLLOW_FAIL(20006, "关注取消关注失败"),
    COMMUNITY_LIKE_UNLIKE_ERROR(20007, "点赞取消点赞异常"),
    COMMUNITY_LIKE_UNLIKE_FAIL(20008, "点赞取消点赞失败"),
    COMMUNITY_ARTICAL_SHARE_CALLBACK_ERROR(20009, "文章转发成功回调异常"),
    COMMUNITY_MOMENT_PUBLISH_ERROR(20010, "发布此时异常"),
    COMMUNITY_MOMENT_PUBLISH_0001(20011, "文章提交失败"),
    COMMUNITY_MOMENT_PUBLISH_0002(20012, "用户已被禁言"),
    COMMUNITY_MOMENT_PUBLISH_0003(20013, "您发布的文字/视频/图片内容涉嫌违规，请修改"),
    COMMUNITY_MOMENT_PUBLISH_0004(20014, "您发布的文字/视频/图片内容可能涉嫌违规，是否立刻修改？"),
    COMMUNITY_COMMENT_PUBLISH_ERROR(20015, "发布评论异常"),
    COMMUNITY_COMMENT_PUBLISH_0001(20016, "评论失败"),
    COMMUNITY_COMMENT_PUBLISH_0002(20017, "用户已被禁言"),
    COMMUNITY_ARTICAL_COLLECT_ERROR(20018, "收藏/取消收藏文章异常"),
    COMMUNITY_ARTICAL_COLLECT_FAIL(20019, "收藏/取消收藏文章失败"),
    COMMUNITY_REPORT_INFO_ERROR(20020, "查询举报信息异常"),
    COMMUNITY_REPORT_ARTICAL_ERROR(20021, "举报文章异常"),
    COMMUNITY_REPORT_ARTICAL_FAIL(20022, "举报文章失败"),
    COMMUNITY_ARTICAL_DELETE_ERROR(20023, "删除文章异常"),
    COMMUNITY_ARTICAL_DELETE_FAIL(20024, "删除文章失败"),
    COMMUNITY_HOMEPAGE_INFO_ERROR(20025, "获取个人主页信息异常"),
    COMMUNITY_HOMEPAGE_MODIFY_ERROR(20026, "修改个人主页基本信息异常"),
    COMMUNITY_HOMEPAGE_MODIFY_FAIL(20027, "修改个人主页基本信息失败"),
    COMMUNITY_FOLLOW_UNFOLLOW_LIST_ERROR(20028, "获取我的关注/粉丝列表异常"),
    COMMUNITY_FOLLOW_UNFOLLOW_LIST_FAIL(20029, "获取我的关注/粉丝列表失败"),
    COMMUNITY_BANNER_LIST_CHANNEL_ERROR(20030,"渠道来源校验失败"),
    COMMUNITY_SERVER_ERROR(20031,"服务器异常"),
    COMMUNITY_REPORT_ARTICAL_REPEAT_ERROR(20032,"您已举报过该文章"),
    // membership业务异常
    // 每个接口调用异常对应一个异常错误码, 使用方法如：ResultGenerator.genResult(RetEnum.MEMBERSHIP_ACTIVATE_ERROR, null);
    // 若非调用异常，而是业务校验错误，则每个接口可用一个错误码代替，
    // 但具体错误信息可从接口调用的返回错误信息里取(若接口没有对应错误信息返回则取这里定义的默认信息）
    // 使用方法如：ResultGenerator.genErrorResult(RetEnum.MEMBERSHIP_ACTIVATE_FAIL.getCode(), '调用接口返回的错误信息')
    MEMBERSHIP_ACTIVATE_ERROR(30001, "激活会员异常"),
    MEMBERSHIP_ACTIVATE_FAIL(30002, "激活会员失败"),
    MEMBERSHIP_BASICINFO_ERROR(30003, "获取会员基本信息异常"),
    MEMBERSHIP_BASICINFO_FAIL(30004, "获取会员基本信息失败"),
    MEMBERSHIP_JOY_EVENT_ERROR(30005, "获取JOY币任务信息异常"),
    MEMBERSHIP_JOY_EVENT_FAIL(30006, "获取JOY币任务信息失败"),
    MEMBERSHIP_JOY_BILLING_ERROR(30007, "获取JOY币记录异常"),
    MEMBERSHIP_JOY_BILLING_FAIL(30008, "获取JOY币记录失败"),
    MEMBERSHIP_BENEFIT_LIST_ERROR(30009, "获取我的权益列表异常"),
    MEMBERSHIP_BENEFIT_LIST_FAIL(30010, "获取我的权益列表失败"),
    MEMBERSHIP_BENEFIT_DETAIL_ERROR(30011, "获取我的权益详情异常"),
    MEMBERSHIP_BENEFIT_DETAIL_FAIL(30012, "获取我的权益详情失败"),
    MEMBERSHIP_VOUCHER_RECEIVE_ERROR(30013, "领取卡券异常"),
    MEMBERSHIP_VOUCHER_RECEIVE_FAIL(30014, "领取卡券失败"),
    MEMBERSHIP_VOUCHER_DEALER_ERROR(30015, "获取卡券所属经销商列表异常"),
    MEMBERSHIP_VOUCHER_DEALER_FAIL(30016, "获取卡券所属经销商列表失败"),
    MEMBERSHIP_VOUCHER_LIST_ERROR(30017, "获取我的卡券列表异常"),
    MEMBERSHIP_VOUCHER_LIST_FAIL(30018, "获取我的卡券列表失败"),
    MEMBERSHIP_VOUCHER_DETAIL_ERROR(30019, "获取我的卡券详情异常"),
    MEMBERSHIP_VOUCHER_DETAIL_FAIL(30020, "获取我的卡券详情失败"),
    MEMBERSHIP_DEALER_BOOK_ERROR(30021, "预约经销商异常"),
    MEMBERSHIP_DEALER_BOOK_FAIL(30022, "预约经销商失败"),
    MEMBERSHIP_DEALER_BIND_ERROR(30023, "绑定经销商异常"),
    MEMBERSHIP_DEALER_BIND_FAIL(30024, "绑定经销商失败"),
    MEMBERSHIP_DEALER_LIST_ERROR(30025, "获取我的经销商列表异常"),
    MEMBERSHIP_DEALER_LIST_FAIL(30026, "获取我的经销商列表失败"),
    MEMBERSHIP_DEALER_DETAIL_ERROR(30027, "获取我的经销商详情异常"),
    MEMBERSHIP_DEALER_DETAIL_FAIL(30028, "获取我的经销商详情失败"),
    MEMBERSHIP_DEALER_UNBIND_ERROR(30029, "解绑我的经销商异常"),
    MEMBERSHIP_DEALER_UNBIND_FAIL(30030, "解绑我的经销商失败"),
    MEMBERSHIP_DEALER_PROVINCE_ERROR(30031, "获取省份信息列表异常"),
    MEMBERSHIP_DEALER_PROVINCE_FAIL(30032, "获取省信息列表失败"),
    MEMBERSHIP_DEALER_CITY_ERROR(30033, "获取省下的市信息列表异常"),
    MEMBERSHIP_DEALER_CITY_FAIL(30034, "获取省下的市信息列表失败"),
    MEMBERSHIP_DEALER_SEARCH_ERROR(30035, "查询经销商异常"),
    MEMBERSHIP_DEALER_SEARCH_FAIL(30036, "查询经销商失败"),
    MEMBERSHIP_UPLOAD_FILE_FAIL(30037,"文件上传失败"),
    MEMBERSHIP_GET_FILE_FAIL(30038,"获取文件失败"),
    MEMBERSHIP_PARAMETER_NOT_ALLOW(90038,"传入参数不能为空"),


    /* ************************************AFS SHOP ************************************************** */
    SHOP_ORDER_SPU_NOT_FOUND(90001,"未查询到SPU信息"),
    SHOP_ORDER_MEMBER_INFO_NOT_FOUND(90002,"未查询到用户信息"),
    SHOP_ACTIVITY_EMPTY(90003,"暂无活动信息"),
    SHOP_ACTIVITY_SEARCH_FAIL(90004,"查询活动信息失败"),
    SHOP_MEMBER_ADD_RECEIVE_ADDRESS_FAIL(90005,"添加收货地址失败"),
    SHOP_RECEIVE_ADDRESS_EMPTY(90006,"未查找到收货地址信息"),
    SHOP_RECEIVE_ADDRESS_SEARCH_FAIL(90007,"查询收货地址信息失败"),
    SHOP_CALCULATE_FREIGHT_FAIL(90008,"计算运费失败"),
    SHOP_DELETE_RECEIVE_ADDRESS_FAIL(90009,"删除收货地址失败"),
    SHOP_DELETE_ORDER_FAIL(90010,"删除订单失败"),
    SHOP_RECEIVE_ADDRESS_NOT_FOUND(90011,"未查找到指定收货地址"),
    SHOP_HOT_PRODUCTS_NOT_FOUND(90012,"未查找到热销商品信息"),
    SHOP_SEARCH_REGION_LIST_FAIL(90013,"查询省市信息似失败"),
    SHOP_UPDATE_RECEIVE_ADDRESS_FAIL(90014,"更新收货地址失败"),
    SHOP_ORDER_PREPAY_ORDERID_ERROR(90015,"获取订单支付参数异常"),
    SHOP_SEARCH_ORDER_LIST_FAIL(90016,"查询订单列表失败"),
    SHOP_CATEGORY_CODE_INVAIL(90017,"商品分类编码无效"),
    /* ************************************ECOMMERCE NEWCARSALES ************************************************** */

    NEWCARSALES_CANCLE_COLLECTION(80001,"取消收藏失败"),
    NEWCARSALES_SEARCH_CARS_FAIL(80002,"查询新车列表失败"),
    NEWCARSALES_SEARCH_CATEGORY_FAIL(80003,"查询车系车型列表失败"),
    NEWCARSALES_SELECT_BANNER_FAIL(80004,"获取首页Banner列表失败"),
    NEWCARSALES_SEARCH_HOT_CAR_FAIL(80005,"获取热销车型失败"),
    NEWCARSALES_COLLECTION_FAIL(80006,"收藏失败"),
    NEWCARSALES_SEND_VERIFY_MESSAGE_FAIL(80007,"发送试驾短信验证码失败"),
    NEWCARSALES_MOBILE_FORMAT_ERROR(80008,"手机号格式错误"),
    NEWCARSALES_SEARCH_NEWCAR_DETAIL_FAIL(80009,"车辆不存在"),
    NEWCARSALES_SEARCH_CAR_OPTIONS_FAIL(80010,"获取车辆属性失败"),
    NEWCARSALES_CREAT_TEST_DRIVE_FAIL(80011,"创建试驾订单失败"),
    NEWCARSALES_ECOMMERCE_TOKEN_FAIL(80012,"token验证失败"),
    NEWCARSALES_ECOMMERCE_DEFINE_FAIL(80013,"ec自定义异常"),
    NEWCARSALES_ECOMMERCE_NETWORK_FAIL(80014,"服务器错误"),
    /* ************************************DEALER SERVICE************************************************** */

    DEALER_DEALER_SEARCH_FAIL(70001,"经销商信息查询失败"),
    DEALER_SEARCH_REGION_FAIL(70002,"查新经销商省市列表失败"),
    GET_CITY_BY_LOCATION_FAIL(70003,"无法根据您的位置查询到信息，请检查定位"),
    AFS_INDICATOR_LIGHT_SEARCH_FAIL(60001,"获取车辆指示灯信息失败"),

    BOCC_Token_INVALID(601,"BoccToken已失效"),
    FEIGN_CALL_FAILED(604,"feign调用失败"),

    //charging booking error
    CHARGING_BOOK_FAIL_NO_PARKING_SPACE(250,"车区不存在,车位已满"),
    CHARGING_BOOK_FAIL_NOT_IN_AVAILIABLE_TIME(251,"不在站点营业时间范围,预约进场时间间隔应大于15分钟，请重新选择"),
    CHARGING_BOOK_FAIL_HAVE_ANOTHER_ORDER(252,"小程序有未完成订单"),
    CHARGING_BOOK_FAIL_HAVE_ANOTHER_EARA(253,"没有专属有散停"),
    /*
    * charging Vip*/
    CHARGING_GET_DEFAULT_PLATE_VIP_ERROR(240,"用户VIP卡已转移或已失效"),
    CHARGING_GET_DEFAULT_PLATE_ERROR(241,"用户没有设置默认车牌"),
    CHARGING_GET_DEFAULT_PLATE_VIP_NOT(242,"用户还不是VIP或没有绑定汽车"),
    CHARGING_GET_ENTRY_TIME_LESS_THAN_NOW(243,"时间不能小于当前时间"),
    CHARGING_GET_EXIT_TIME_LESS_THAN_ENTRY(245,"出场时间不能小于进场时间"),
    CHARGING_TIME_FORMAT_ERROR(246,"时间格式不正确"),
    CHARGING_PAY_OR_CANCLE_OVERTIMECANCLED(247,"订单超时，已自动取消"),
    CHARGING_CANCLE_ERROR_OVERTIME_TO_EXIT(248,"超过预约离场时间，订单不允许取消"),

    CHARGING_BOOK_PARK_FAIL_HHFAILD(249, "失败"),
    CHARGING_CANCLE_ERROR_NOT_FOUND_ORDER(250, "该订单不存在")
    ;

    private int code;
    private String message;

    private RetEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static RetEnum getRetEnum(int code) {
        if (code == 0) {
            return null;
        }

        RetEnum[] values = RetEnum.values();
        for (RetEnum e : values) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}

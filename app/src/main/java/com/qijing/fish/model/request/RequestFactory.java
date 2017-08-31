package com.qijing.fish.model.request;

/**
 * Created by czl on 2017/6/28.
 */

public class RequestFactory {
    /**
     * 请求第一层
     * **/
    private BaseModuleRequset baseRequest;
    /**
     *  请求第二层
     */
    private BaseModel baseModel;
    /**
     *  请求的实体类
     */
    private BaseBean baseBean;

    public RequestFactory(Builder builder) {
        this.baseRequest = builder.baseRequest;
        this.baseModel = builder.baseModel;
        this.baseBean = builder.baseBean;
    }

    /**
     *  返回具体的接口请求数据
     * @return
     */
    public String MakeRequestBody () {
        this.baseModel.baseBean = this.baseBean;
        this.baseRequest.dModel = this.baseModel;
        return this.baseRequest.toJson();
    }

    public static class Builder {
        /**
         * 请求第一层
         * **/
        private BaseModuleRequset baseRequest;
        /**
         *  请求第二层
         */
        private BaseModel baseModel;
        /**
         *  请求的实体类
         */
        private BaseBean baseBean;

        public Builder addBase(BaseModuleRequset baseRequest) {
            this.baseRequest = baseRequest;
            return  this;
        }

        public Builder addModel(BaseModel baseModel) {
            this.baseModel = baseModel;
            return this;
        }

        public Builder addBean(BaseBean baseBean) {
            this.baseBean = baseBean;
            return this;
        }

        public RequestFactory bulid() {
            return new RequestFactory(this);
        }
    }
}

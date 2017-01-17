package com.code19.retrofitdemo.data.remote.model;

import java.util.List;

/**
 * Created by gh0st on 2016/12/27.
 */

public class Index {

    private int status;
    private String info;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String tx_ico;
        private String com_name;
        private String type;
        private String intro;
        private String ebuy_login;
        private String truename;
        private String pid;
        private String show_pics;
        private String telphone;
        private String qq;
        private String weixin;
        private String province;
        private String city;
        private String district;
        private String address;
        private String role_id;
        private String pic;
        private String is_add;
        private String add_time;
        private String is_price;
        private String retail;
        private String is_jc_show;
        private String is_pic;
        private String price_type;
        private String display_msg;
        private String display_title;
        private String show_name;
        private ShareObjBean shareObj;
        private String jcjnurl;
        private String activityurl;
        private List<?> brands;
        private List<ActicityListBean> acticity_list;

        public String getTx_ico() {
            return tx_ico;
        }

        public void setTx_ico(String tx_ico) {
            this.tx_ico = tx_ico;
        }

        public String getCom_name() {
            return com_name;
        }

        public void setCom_name(String com_name) {
            this.com_name = com_name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getEbuy_login() {
            return ebuy_login;
        }

        public void setEbuy_login(String ebuy_login) {
            this.ebuy_login = ebuy_login;
        }

        public String getTruename() {
            return truename;
        }

        public void setTruename(String truename) {
            this.truename = truename;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getShow_pics() {
            return show_pics;
        }

        public void setShow_pics(String show_pics) {
            this.show_pics = show_pics;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getIs_add() {
            return is_add;
        }

        public void setIs_add(String is_add) {
            this.is_add = is_add;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getIs_price() {
            return is_price;
        }

        public void setIs_price(String is_price) {
            this.is_price = is_price;
        }

        public String getRetail() {
            return retail;
        }

        public void setRetail(String retail) {
            this.retail = retail;
        }

        public String getIs_jc_show() {
            return is_jc_show;
        }

        public void setIs_jc_show(String is_jc_show) {
            this.is_jc_show = is_jc_show;
        }

        public String getIs_pic() {
            return is_pic;
        }

        public void setIs_pic(String is_pic) {
            this.is_pic = is_pic;
        }

        public String getPrice_type() {
            return price_type;
        }

        public void setPrice_type(String price_type) {
            this.price_type = price_type;
        }

        public String getDisplay_msg() {
            return display_msg;
        }

        public void setDisplay_msg(String display_msg) {
            this.display_msg = display_msg;
        }

        public String getDisplay_title() {
            return display_title;
        }

        public void setDisplay_title(String display_title) {
            this.display_title = display_title;
        }

        public String getShow_name() {
            return show_name;
        }

        public void setShow_name(String show_name) {
            this.show_name = show_name;
        }

        public ShareObjBean getShareObj() {
            return shareObj;
        }

        public void setShareObj(ShareObjBean shareObj) {
            this.shareObj = shareObj;
        }

        public String getJcjnurl() {
            return jcjnurl;
        }

        public void setJcjnurl(String jcjnurl) {
            this.jcjnurl = jcjnurl;
        }

        public String getActivityurl() {
            return activityurl;
        }

        public void setActivityurl(String activityurl) {
            this.activityurl = activityurl;
        }

        public List<?> getBrands() {
            return brands;
        }

        public void setBrands(List<?> brands) {
            this.brands = brands;
        }

        public List<ActicityListBean> getActicity_list() {
            return acticity_list;
        }

        public void setActicity_list(List<ActicityListBean> acticity_list) {
            this.acticity_list = acticity_list;
        }

        public static class ShareObjBean {

            private String shareTitle;
            private String shareDesc;
            private String shareLogo;
            private String shareUrl;

            public String getShareTitle() {
                return shareTitle;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public String getShareDesc() {
                return shareDesc;
            }

            public void setShareDesc(String shareDesc) {
                this.shareDesc = shareDesc;
            }

            public String getShareLogo() {
                return shareLogo;
            }

            public void setShareLogo(String shareLogo) {
                this.shareLogo = shareLogo;
            }

            public String getShareUrl() {
                return shareUrl;
            }

            public void setShareUrl(String shareUrl) {
                this.shareUrl = shareUrl;
            }
        }

        public static class ActicityListBean {

            private String id;
            private String cat_id;
            private String title;
            private String addtime;
            private String updatetime;
            private String cat_pic;
            private String url;
            private String short_name;
            private CatobjBean catobj;
            private ImgfBean imgf;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCat_id() {
                return cat_id;
            }

            public void setCat_id(String cat_id) {
                this.cat_id = cat_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getCat_pic() {
                return cat_pic;
            }

            public void setCat_pic(String cat_pic) {
                this.cat_pic = cat_pic;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public CatobjBean getCatobj() {
                return catobj;
            }

            public void setCatobj(CatobjBean catobj) {
                this.catobj = catobj;
            }

            public ImgfBean getImgf() {
                return imgf;
            }

            public void setImgf(ImgfBean imgf) {
                this.imgf = imgf;
            }

            public static class CatobjBean {

                private String cat_id;
                private String cat_name;

                public String getCat_id() {
                    return cat_id;
                }

                public void setCat_id(String cat_id) {
                    this.cat_id = cat_id;
                }

                public String getCat_name() {
                    return cat_name;
                }

                public void setCat_name(String cat_name) {
                    this.cat_name = cat_name;
                }
            }

            public static class ImgfBean {

                private String pic;
                private String msg;
                private int imgWidth;
                private int imgHeight;

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getMsg() {
                    return msg;
                }

                public void setMsg(String msg) {
                    this.msg = msg;
                }

                public int getImgWidth() {
                    return imgWidth;
                }

                public void setImgWidth(int imgWidth) {
                    this.imgWidth = imgWidth;
                }

                public int getImgHeight() {
                    return imgHeight;
                }

                public void setImgHeight(int imgHeight) {
                    this.imgHeight = imgHeight;
                }
            }
        }
    }
}

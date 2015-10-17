package com.fuck.formoney.activity.recommend;

import java.util.List;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午7:41
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午7:41
 * 修改备注：
 */
public class DetailModel {

    /**
     * resultMsg : 数据加载成功
     * statusCode : 200
     * data : {"createDate":"2015-09-25 00:55:45","id":2,"sortNum":2,"taskImageDatas":[{"content":"","id":2,"imgHeight":550,"imgPath":"http://moneyhome.image.alimmdn.com/app/image/2015-10-17/550.jpg","imgWidth":310,"taskItemInfoId":1}],"taskImgHeight":200,"taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskImgWidth":200,"taskItemAwardIntegral":2,"taskItemAwardMoney":0.1,"taskItemAwardType":"","taskItemContent":"","taskItemDeadline":"2015-10-25 00:57:25","taskItemDesc":"下载安装，试玩3分钟奖励","taskItemName":"夜魂_1","taskItemOrder":"","taskItemType":"","taskItemUrl":"","taskItemUrlAndroid":"","taskItemUrlIos":"","taskRemainCopies":110}
     */

    private String resultMsg;
    private int statusCode;
    private DataEntity data;

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * createDate : 2015-09-25 00:55:45
         * id : 2
         * sortNum : 2
         * taskImageDatas : [{"content":"","id":2,"imgHeight":550,"imgPath":"http://moneyhome.image.alimmdn.com/app/image/2015-10-17/550.jpg","imgWidth":310,"taskItemInfoId":1}]
         * taskImgHeight : 200
         * taskImgPath : http://moneyhome.image.alimmdn.com/app/image/test/test4
         * taskImgWidth : 200
         * taskItemAwardIntegral : 2
         * taskItemAwardMoney : 0.1
         * taskItemAwardType :
         * taskItemContent :
         * taskItemDeadline : 2015-10-25 00:57:25
         * taskItemDesc : 下载安装，试玩3分钟奖励
         * taskItemName : 夜魂_1
         * taskItemOrder :
         * taskItemType :
         * taskItemUrl :
         * taskItemUrlAndroid :
         * taskItemUrlIos :
         * taskRemainCopies : 110
         */

        private String createDate;
        private int id;
        private int sortNum;
        private int taskImgHeight;
        private String taskImgPath;
        private int taskImgWidth;
        private int taskItemAwardIntegral;
        private double taskItemAwardMoney;
        private String taskItemAwardType;
        private String taskItemContent;
        private String taskItemDeadline;
        private String taskItemDesc;
        private String taskItemName;
        private String taskItemOrder;
        private String taskItemType;
        private String taskItemUrl;
        private String taskItemUrlAndroid;
        private String taskItemUrlIos;
        private int taskRemainCopies;
        private List<TaskImageDatasEntity> taskImageDatas;

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSortNum(int sortNum) {
            this.sortNum = sortNum;
        }

        public void setTaskImgHeight(int taskImgHeight) {
            this.taskImgHeight = taskImgHeight;
        }

        public void setTaskImgPath(String taskImgPath) {
            this.taskImgPath = taskImgPath;
        }

        public void setTaskImgWidth(int taskImgWidth) {
            this.taskImgWidth = taskImgWidth;
        }

        public void setTaskItemAwardIntegral(int taskItemAwardIntegral) {
            this.taskItemAwardIntegral = taskItemAwardIntegral;
        }

        public void setTaskItemAwardMoney(double taskItemAwardMoney) {
            this.taskItemAwardMoney = taskItemAwardMoney;
        }

        public void setTaskItemAwardType(String taskItemAwardType) {
            this.taskItemAwardType = taskItemAwardType;
        }

        public void setTaskItemContent(String taskItemContent) {
            this.taskItemContent = taskItemContent;
        }

        public void setTaskItemDeadline(String taskItemDeadline) {
            this.taskItemDeadline = taskItemDeadline;
        }

        public void setTaskItemDesc(String taskItemDesc) {
            this.taskItemDesc = taskItemDesc;
        }

        public void setTaskItemName(String taskItemName) {
            this.taskItemName = taskItemName;
        }

        public void setTaskItemOrder(String taskItemOrder) {
            this.taskItemOrder = taskItemOrder;
        }

        public void setTaskItemType(String taskItemType) {
            this.taskItemType = taskItemType;
        }

        public void setTaskItemUrl(String taskItemUrl) {
            this.taskItemUrl = taskItemUrl;
        }

        public void setTaskItemUrlAndroid(String taskItemUrlAndroid) {
            this.taskItemUrlAndroid = taskItemUrlAndroid;
        }

        public void setTaskItemUrlIos(String taskItemUrlIos) {
            this.taskItemUrlIos = taskItemUrlIos;
        }

        public void setTaskRemainCopies(int taskRemainCopies) {
            this.taskRemainCopies = taskRemainCopies;
        }

        public void setTaskImageDatas(List<TaskImageDatasEntity> taskImageDatas) {
            this.taskImageDatas = taskImageDatas;
        }

        public String getCreateDate() {
            return createDate;
        }

        public int getId() {
            return id;
        }

        public int getSortNum() {
            return sortNum;
        }

        public int getTaskImgHeight() {
            return taskImgHeight;
        }

        public String getTaskImgPath() {
            return taskImgPath;
        }

        public int getTaskImgWidth() {
            return taskImgWidth;
        }

        public int getTaskItemAwardIntegral() {
            return taskItemAwardIntegral;
        }

        public double getTaskItemAwardMoney() {
            return taskItemAwardMoney;
        }

        public String getTaskItemAwardType() {
            return taskItemAwardType;
        }

        public String getTaskItemContent() {
            return taskItemContent;
        }

        public String getTaskItemDeadline() {
            return taskItemDeadline;
        }

        public String getTaskItemDesc() {
            return taskItemDesc;
        }

        public String getTaskItemName() {
            return taskItemName;
        }

        public String getTaskItemOrder() {
            return taskItemOrder;
        }

        public String getTaskItemType() {
            return taskItemType;
        }

        public String getTaskItemUrl() {
            return taskItemUrl;
        }

        public String getTaskItemUrlAndroid() {
            return taskItemUrlAndroid;
        }

        public String getTaskItemUrlIos() {
            return taskItemUrlIos;
        }

        public int getTaskRemainCopies() {
            return taskRemainCopies;
        }

        public List<TaskImageDatasEntity> getTaskImageDatas() {
            return taskImageDatas;
        }

        public static class TaskImageDatasEntity {
            /**
             * content :
             * id : 2
             * imgHeight : 550
             * imgPath : http://moneyhome.image.alimmdn.com/app/image/2015-10-17/550.jpg
             * imgWidth : 310
             * taskItemInfoId : 1
             */

            private String content;
            private int id;
            private int imgHeight;
            private String imgPath;
            private int imgWidth;
            private int taskItemInfoId;

            public void setContent(String content) {
                this.content = content;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImgHeight(int imgHeight) {
                this.imgHeight = imgHeight;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public void setImgWidth(int imgWidth) {
                this.imgWidth = imgWidth;
            }

            public void setTaskItemInfoId(int taskItemInfoId) {
                this.taskItemInfoId = taskItemInfoId;
            }

            public String getContent() {
                return content;
            }

            public int getId() {
                return id;
            }

            public int getImgHeight() {
                return imgHeight;
            }

            public String getImgPath() {
                return imgPath;
            }

            public int getImgWidth() {
                return imgWidth;
            }

            public int getTaskItemInfoId() {
                return taskItemInfoId;
            }
        }
    }
}

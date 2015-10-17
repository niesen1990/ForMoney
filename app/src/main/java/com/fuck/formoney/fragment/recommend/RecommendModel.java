package com.fuck.formoney.fragment.recommend;

import java.util.List;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15-10-17 下午2:04
 * 修改人：N.Sun
 * 修改时间：15-10-17 下午2:04
 * 修改备注：
 */
public class RecommendModel{

    /**
     * resultMsg : 数据加载成功
     * statusCode : 200
     * data : {"firstPage":true,"firstResult":0,"lastPage":true,"list":[{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_3","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":130,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":2,"isDelete":0,"id":4,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1},{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_2","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":120,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":2,"isDelete":0,"id":3,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1},{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_1","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":110,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":2,"isDelete":0,"id":2,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1},{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_0","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":100,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":3,"isDelete":0,"id":1,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1}],"nextPage":1,"pageNo":1,"pageSize":10,"prePage":1,"totalCount":4,"totalPage":1}
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
         * firstPage : true
         * firstResult : 0
         * lastPage : true
         * list : [{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_3","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":130,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":2,"isDelete":0,"id":4,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1},{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_2","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":120,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":2,"isDelete":0,"id":3,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1},{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_1","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":110,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":2,"isDelete":0,"id":2,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1},{"taskItemAwardMoney":0.1,"taskItemName":"夜魂_0","taskItemContent":"","completeState":0,"taskItemDeadline":"2015-10-25 00:57:25","taskImgPath":"http://moneyhome.image.alimmdn.com/app/image/test/test4","taskRemainCopies":100,"taskImgWidth":200,"taskItemAwardType":1,"sortNum":3,"isDelete":0,"id":1,"packetName":"com.cmbb.smartkids","taskItemAwardIntegral":2,"taskImgHeight":200,"taskItemUrl":"","createDate":"2015-09-25 00:55:45","taskItemDesc":"下载安装，试玩3分钟奖励","taskTypeId":1}]
         * nextPage : 1
         * pageNo : 1
         * pageSize : 10
         * prePage : 1
         * totalCount : 4
         * totalPage : 1
         */

        private boolean firstPage;
        private int firstResult;
        private boolean lastPage;
        private int nextPage;
        private int pageNo;
        private int pageSize;
        private int prePage;
        private int totalCount;
        private int totalPage;
        private List<ListEntity> list;

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public void setFirstResult(int firstResult) {
            this.firstResult = firstResult;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public boolean getFirstPage() {
            return firstPage;
        }

        public int getFirstResult() {
            return firstResult;
        }

        public boolean getLastPage() {
            return lastPage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public int getPageNo() {
            return pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public int getPrePage() {
            return prePage;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity {
            /**
             * taskItemAwardMoney : 0.1
             * taskItemName : 夜魂_3
             * taskItemContent :
             * completeState : 0
             * taskItemDeadline : 2015-10-25 00:57:25
             * taskImgPath : http://moneyhome.image.alimmdn.com/app/image/test/test4
             * taskRemainCopies : 130
             * taskImgWidth : 200
             * taskItemAwardType : 1
             * sortNum : 2
             * isDelete : 0
             * id : 4
             * packetName : com.cmbb.smartkids
             * taskItemAwardIntegral : 2.0
             * taskImgHeight : 200
             * taskItemUrl :
             * createDate : 2015-09-25 00:55:45
             * taskItemDesc : 下载安装，试玩3分钟奖励
             * taskTypeId : 1
             */

            private double taskItemAwardMoney;
            private String taskItemName;
            private String taskItemContent;
            private int completeState;
            private String taskItemDeadline;
            private String taskImgPath;
            private int taskRemainCopies;
            private int taskImgWidth;
            private int taskItemAwardType;
            private int sortNum;
            private int isDelete;
            private int id;
            private String packetName;
            private double taskItemAwardIntegral;
            private int taskImgHeight;
            private String taskItemUrl;
            private String createDate;
            private String taskItemDesc;
            private int taskTypeId;

            public void setTaskItemAwardMoney(double taskItemAwardMoney) {
                this.taskItemAwardMoney = taskItemAwardMoney;
            }

            public void setTaskItemName(String taskItemName) {
                this.taskItemName = taskItemName;
            }

            public void setTaskItemContent(String taskItemContent) {
                this.taskItemContent = taskItemContent;
            }

            public void setCompleteState(int completeState) {
                this.completeState = completeState;
            }

            public void setTaskItemDeadline(String taskItemDeadline) {
                this.taskItemDeadline = taskItemDeadline;
            }

            public void setTaskImgPath(String taskImgPath) {
                this.taskImgPath = taskImgPath;
            }

            public void setTaskRemainCopies(int taskRemainCopies) {
                this.taskRemainCopies = taskRemainCopies;
            }

            public void setTaskImgWidth(int taskImgWidth) {
                this.taskImgWidth = taskImgWidth;
            }

            public void setTaskItemAwardType(int taskItemAwardType) {
                this.taskItemAwardType = taskItemAwardType;
            }

            public void setSortNum(int sortNum) {
                this.sortNum = sortNum;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setPacketName(String packetName) {
                this.packetName = packetName;
            }

            public void setTaskItemAwardIntegral(double taskItemAwardIntegral) {
                this.taskItemAwardIntegral = taskItemAwardIntegral;
            }

            public void setTaskImgHeight(int taskImgHeight) {
                this.taskImgHeight = taskImgHeight;
            }

            public void setTaskItemUrl(String taskItemUrl) {
                this.taskItemUrl = taskItemUrl;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public void setTaskItemDesc(String taskItemDesc) {
                this.taskItemDesc = taskItemDesc;
            }

            public void setTaskTypeId(int taskTypeId) {
                this.taskTypeId = taskTypeId;
            }

            public double getTaskItemAwardMoney() {
                return taskItemAwardMoney;
            }

            public String getTaskItemName() {
                return taskItemName;
            }

            public String getTaskItemContent() {
                return taskItemContent;
            }

            public int getCompleteState() {
                return completeState;
            }

            public String getTaskItemDeadline() {
                return taskItemDeadline;
            }

            public String getTaskImgPath() {
                return taskImgPath;
            }

            public int getTaskRemainCopies() {
                return taskRemainCopies;
            }

            public int getTaskImgWidth() {
                return taskImgWidth;
            }

            public int getTaskItemAwardType() {
                return taskItemAwardType;
            }

            public int getSortNum() {
                return sortNum;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public int getId() {
                return id;
            }

            public String getPacketName() {
                return packetName;
            }

            public double getTaskItemAwardIntegral() {
                return taskItemAwardIntegral;
            }

            public int getTaskImgHeight() {
                return taskImgHeight;
            }

            public String getTaskItemUrl() {
                return taskItemUrl;
            }

            public String getCreateDate() {
                return createDate;
            }

            public String getTaskItemDesc() {
                return taskItemDesc;
            }

            public int getTaskTypeId() {
                return taskTypeId;
            }
        }
    }
}

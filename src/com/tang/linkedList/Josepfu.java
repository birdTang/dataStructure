package com.tang.linkedList;


/**
 * 约瑟夫问题
 * @author tangp
 * @date 2020-04-20 22:18;
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();
        circleSingleLinkList.addBoy(5);
        circleSingleLinkList.list();

        circleSingleLinkList.chuquan(1,2,5);


    }
}

/**
 * 循环单向列表
 */
class CircleSingleLinkList{
    //创建first节点
    private Boy first;
    private Boy curBoy;

    //加入节点，构建成环形列表
    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("num不正确,至少要有一个小孩");
            return;
        }
        //使用for循环构建环形列表
        for (int i=1;i<=num;i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i==1) {
                first = boy;
                first.setNext(boy);
                curBoy  = first; //让curboy只指向第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    //根据用户输入，计算小孩出圈顺序
    //startNo:从第几个小孩开始数数
    //countNUm:数几下
    //nums：最初有几个小孩在圈中
    public void chuquan(int startNo,int countNum,int nums) {
        if(first==null || startNo<1 || startNo>nums) {
            System.out.println("输入有误");
            return;
        }
        Boy helper = first;
        //循环遍历，让helper指向first的前一位
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先将first和helper移动startNo-1次
        for(int i=0;i<startNo-1;i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //报数,让first和helper同时移动countNum-1位，直到圈中只有一人
        while (true) {
            if (helper == first) {
                //圈中只有1人了
                System.out.println("最后出圈的小孩："+ helper.getNo());
                break;
            }
            for(int i=0;i<countNum-1;i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩出圈："+ first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }

    public void list() {
        if(first==null) {
            System.out.println("当前没有小孩");
            return;
        }
        Boy curBoy = first; //循环辅助节点
        while (true){
            System.out.printf("当前小孩的编号 %d \n",curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}


class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

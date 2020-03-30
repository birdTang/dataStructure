package com.tang.linkedList;

public class DoubleLinkedListDemo {

	
}

class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, null, null);

	public void add(HeroNode2 node) {
		HeroNode2 temp = head;
		//查找尾节点插入
		while(temp.getNext()!=null) {
			temp = temp.getNext();
		}
		//形成一个双向列表
		temp.setNext(node);
		node.pre = temp;
		
	}
	//修改，假设需求是：no不能修改，和单链表一样
	public void update(HeroNode node) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head;
		boolean exist = false;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.getNo()==node.getNo()) {
				exist = true;
				break;
			}
			temp = temp.next;
		}
		if(exist) {
			temp.setName(node.getName());
			temp.setNickName(node.getNickName());
		}else {
			System.out.printf("数据不存在,编号为%d\n",node.getNo());
		}
	}
	
	//
	public void delete(int no) {
		if(head.next==null) {
			return;
		}
		HeroNode2 temp = head.next;
		boolean exist = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.getNo()==no) {
				exist = true;
				break;
			}
			temp = temp.next;
		}
		if(exist) {
			temp.pre.next = temp.next;
			if(temp.next!=null)
				temp.next.pre = temp.pre;
		}else {
			System.out.printf("数据不存在%d\n",no);
		}
	}
	public void list() {
		HeroNode2 temp = head.getNext();
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp =temp.getNext();
		}
	}
}

class HeroNode2 {
	private int no;
	private String name;
	private String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;
	
	
	public HeroNode2(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public HeroNode2 getNext() {
		return next;
	}


	public void setNext(HeroNode2 next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickName="
				+ nickName + ", next=" + next + ", pre=" + pre + "]";
	}


}

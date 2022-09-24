# 1、两数之和

## length的使用

1. `length`

   length是属性，是**数组**的长度，使用时的形式是：数组`.length`不加括号

2. `length()`

   length()是**字符串**自带的方法，是求字符串长度的，使用形式是：`str.length()`

3. `size()`

   size()是**列表**的自带方法，求的是列表的长度，使用形式是：`list.size()`



2

3

# 4、寻找两个正序数组的中位数

![image-20220922220554936](pic/image-20220922220554936.png)



# 5、最长回文子串

## 中心扩张法

![image-20220920211209159](pic/image-20220920211209159.png)

### 注意

1. 注意出现“aaaa”、“aaa”这样相同字符的回文子串，因此需要在第一个while循环中判断从当前i开始左右是否相同。

2. 在完成相同字符的判断后，进行left-1和right+1同时判断，查找回文数。

3. 时间复杂度：O(n^2)

   空间复杂度：O(1)

   时间换空间

### 替换

1. 将字符串转为数组的方式有：

   ```java
   char[] str = s.toCharArray();
   ```

2. 提取字符串中某一下标的字符：

   ```java
   char st = s.charAt(3);
   ```


## 动态规划

![image-20220920211102615](pic/image-20220920211102615.png)

二维数组是动态规划最常用的方法

### 注意

1. 此方法核心在于按照子串长度进行遍历，判断l长度的子串是否为回文子串，即判断除去两个端点的子串是否为回文子串

2. 1中至少要有三个元素。在只有1个元素时，回文子串就是它自己；有两个元素时，如果两个元素相等则为回文子串。

3. 时间复杂度：O(n^2)

   空间复杂度：O(n^2)



# 11、盛最多水的容器⭐

![image-20220924130921512](pic/image-20220924130921512.png)

逻辑性很强



# 15、三数之和

![image-20220924125048130](pic/image-20220924125048130.png)

1. List<List<Integer>> 的定义

   ```java
   List<List<Integer>> result = new ArrayList<List<Integer>>();
   ```

2. List<Integer>的定义

   ```java
   List<Integer> r = new ArrayList<Integer>()
   ```

3. List的添加操作

   ```java
   list1.add(r);    //r必须是list的<>内的类型，在尾部插入
   ```

4. List的搜索操作

   ```java
   list1.get(index);    //获取list下标为index的数值
   ```

5. int转为Integer

   ```java
   int a;
   Integer b = Integer.valueOf(a);
   ```

6. 数组的排序

   ```java
   Arrays.sort(nums);     //原地修改nums数组
   ```



# 26、删除有序数组中的重复项

![image-20220924130553781](pic/image-20220924130553781.png)

双指针思路



# 68、文本左右对齐⭐







# 707、设计链表

![image-20220923102230396](pic/image-20220923102230396.png)

Java语言使用链表格式：

```java
class MyLinkedList {
    static class Node {
        int val;
        Node pre;
        Node next;
        public Node() {
        }
        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size=0;

    public MyLinkedList() {
        head = new Node();
        head.next = head;
        head.pre = head;
    }
    
    public int get(int index) {
        Node node = head;
        //......
    }
    //......
}

//调用
MyLinkedList linkedList = new MyLinkedList();
linkedList.get(1);    
```







# 1640、能否连接形成数组

![image-20220922221718430](pic/image-20220922221718430.png)



# 1652、拆炸弹

![image-20220924104449440](pic/image-20220924104449440.png)

负数的求余：

被除数的绝对值与除数绝对值取余的值即为余数绝对值，余数符号与被除数一致。

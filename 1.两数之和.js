/*
 * @lc app=leetcode.cn id=2 lang=javascript
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 是否进位标志
 */
let addFlag = false;
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
  //初始化标记
  addFlag = false;
  //根数据
  let rootData = getResult(l1, l2);
  //最后一个数据
  let tailData = rootData;
  //新计算的数据
  let newData = null;
  do {
    l1 = l1 == null ? null : l1.next;
    l2 = l2 == null ? null : l2.next;
    //计算数据...
    newData = getResult(l1, l2);
    tailData.next = newData;
    if (newData != null) {
      tailData = newData;
    }
  } while (newData != null);
  //处理进位
  if (addFlag) {
    tailData.next = {
      val: 1
    };
  }

  return rootData;
};

function getResult(l1, l2) {
  //l1,l2都为空返回 null
  if (l1 == null && l2 == null) {
    return null;
  }
  //null当做 0 算
  let l1Val = l1 == null ? 0 : l1.val;
  let l2Val = l2 == null ? 0 : l2.val;

  let val = l1Val + l2Val + (addFlag ? 1 : 0);
  //处理进位
  addFlag = val >= 10;
  //取余数
  val = val % 10;

  return {
    val
  };
}

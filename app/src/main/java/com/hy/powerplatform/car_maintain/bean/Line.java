package com.hy.powerplatform.car_maintain.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Line implements Serializable {

    /**
     * success : true
     * data : [{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55375,"lineCode":"11","lineName":"11路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"24.5","yyCar":"51","memo":"","lineType":"","smz":"高士北路口\u2014\u2014泰极驾校"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55388,"lineCode":"1111","lineName":"一队大机动","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"2","lineMile":"","yyCar":"51","memo":"","lineType":"","smz":""},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55395,"lineCode":"115","lineName":"115路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"3","lineMile":"61","yyCar":"24","memo":"","lineType":"","smz":"火车站－明月山机场"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55396,"lineCode":"116","lineName":"116路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1-3","lineMile":"43.4","yyCar":"34","memo":"","lineType":"","smz":"明月立交\u2014\u2014温汤"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55397,"lineCode":"118","lineName":"118路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1-5","lineMile":"70.7","yyCar":"40","memo":"","lineType":"","smz":"明月立交\u2014\u2014明月山"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55406,"lineCode":"12","lineName":"12路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"26.5","yyCar":"27","memo":"","lineType":"","smz":"科技馆（西）\u2014\u2014武警宜春教导队"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55376,"lineCode":"1302","lineName":"13路短线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"14.8","yyCar":"15","memo":"","lineType":"","smz":"高士北路口\u2014\u2014上元（信和）"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55377,"lineCode":"15","lineName":"15路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"20.8","yyCar":"21","memo":"","lineType":"","smz":"邮桥\u2014\u2014林桥"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55407,"lineCode":"16","lineName":"16路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"26.4","yyCar":"9","memo":"","lineType":"","smz":"明月立交\u2014\u2014下巩（或军背）"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55393,"lineCode":"18","lineName":"18路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"16.8","yyCar":"3","memo":"","lineType":"","smz":"天泽医院\u2014\u2014一寺"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55409,"lineCode":"19","lineName":"19路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"37.1","yyCar":"42","memo":"","lineType":"","smz":"明月山机场－火车站"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55385,"lineCode":"190","lineName":"秀江路专线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"15.8","yyCar":"3","memo":"","lineType":"","smz":"原市委-市医院北院"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55384,"lineCode":"193","lineName":"经开区2号线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"20","yyCar":"8","memo":"","lineType":"","smz":"经开区物流中心-客商行政服务中心"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55383,"lineCode":"194","lineName":"经开区3号线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"29","yyCar":"15","memo":"","lineType":"","smz":"汇仁药业-双琦化工"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55417,"lineCode":"197","lineName":"经开区1号线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"","yyCar":"6","memo":"","lineType":"","smz":""},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55394,"lineCode":"20","lineName":"20路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"25","yyCar":"42","memo":"","lineType":"","smz":"汽车北站\u2014\u2014火车站"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55378,"lineCode":"21","lineName":"21路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"29.6","yyCar":"36","memo":"","lineType":"","smz":"街心花园\u2014\u2014经开区物流中心"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55380,"lineCode":"210","lineName":"31路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"33.5","yyCar":"42","memo":"","lineType":"","smz":"街心花园\u2014\u2014袁州区工业园"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55410,"lineCode":"22","lineName":"22路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"27.1","yyCar":"42","memo":"","lineType":"","smz":"市医院北院\u2014\u2014国光超市"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55399,"lineCode":"2222","lineName":"二队大机动","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"2","lineMile":"50","yyCar":"40","memo":"","lineType":"","smz":""},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55379,"lineCode":"23","lineName":"23路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"10.6","yyCar":"15","memo":"","lineType":"","smz":"怡兰花园\u2014\u2014街心花园"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55411,"lineCode":"26","lineName":"26路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"20","yyCar":"33","memo":"","lineType":"","smz":"禅博园\u2014\u2014街心花园"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55372,"lineCode":"3","lineName":"3路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"14.6","yyCar":"33","memo":"","lineType":"","smz":"麻纺厂\u2014\u2014国光超市"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55413,"lineCode":"301","lineName":"机场专线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"5","lineMile":"51.2","yyCar":"6","memo":"","lineType":"","smz":"明月山机场－火车站"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55381,"lineCode":"32","lineName":"32路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"33.5","yyCar":"16","memo":"","lineType":"","smz":"市行政中心---经都学校"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55382,"lineCode":"33","lineName":"33路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"2","lineMile":"22","yyCar":"21","memo":"","lineType":"","smz":"荷塘月色\u2014\u2014交警大队"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55414,"lineCode":"3333","lineName":"三队大机动","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"2","lineMile":"","yyCar":"172","memo":"","lineType":"","smz":""},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55400,"lineCode":"4","lineName":"4路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"25.2","yyCar":"49","memo":"","lineType":"","smz":"金桥\u2014\u2014宜春碧桂园"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55412,"lineCode":"4171","lineName":"27路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"16.7","yyCar":"30","memo":"","lineType":"","smz":"和园小区\u2014\u2014朝阳西路"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55408,"lineCode":"4172","lineName":"17路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"21.7","yyCar":"33","memo":"","lineType":"","smz":"万达广场\u2014\u2014鼓楼路口"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55389,"lineCode":"4401","lineName":"1路A","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"18.9","yyCar":"71","memo":"","lineType":"","smz":"公交南站（怡欣花园）-花博园"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55374,"lineCode":"4408","lineName":"8路A","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"18.7","yyCar":"34","memo":"","lineType":"","smz":"公交总站\u2014\u2014宜春学院 "},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55405,"lineCode":"4410","lineName":"10路A","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"13","yyCar":"24","memo":"","lineType":"","smz":"徐田小区\u2014\u2014鼓楼路口"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55415,"lineCode":"4421","lineName":"2路北","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"16","yyCar":"0","memo":"","lineType":"","smz":"火车站\u2014\u2014交警大队"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55390,"lineCode":"4422","lineName":"2路南","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"16","yyCar":"40","memo":"","lineType":"","smz":"火车站\u2014\u2014汽车西站"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55392,"lineCode":"5","lineName":"5路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"25.5","yyCar":"73","memo":"","lineType":"","smz":"市行政中心\u2014\u2014醉仙楼"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55373,"lineCode":"6","lineName":"6路","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"30.2","yyCar":"91","memo":"","lineType":"","smz":"公交总站\u2014第九中学"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55398,"lineCode":"663","lineName":"夜班一号线","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":506,"depName":"营运二分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.506.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:45","updateId":1,"updatetime":"2018-07-13 18:21:45","sn":12,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"14.5","yyCar":"6","memo":"","lineType":"","smz":"火车站\u2014\u2014街心花园"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55402,"lineCode":"70","lineName":"7路外","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"25.5","yyCar":"30","memo":"","lineType":"","smz":"市医院北院·宜春恒大御景\u2014\u2014昌黎大桥"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55401,"lineCode":"71","lineName":"7路内","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"25.2","yyCar":"33","memo":"","lineType":"","smz":"市医院北院·宜春恒大御景\u2014\u2014昌黎大桥"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55403,"lineCode":"91","lineName":"9路内","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"15.8","yyCar":"24","memo":"","lineType":"","smz":"火车站\u2014\u2014鼓楼路口"},{"version":null,"orgId":null,"orgPath":null,"lineInfoId":55404,"lineCode":"92","lineName":"9路外","depId":null,"department":{"version":null,"orgId":null,"orgPath":null,"depId":507,"depName":"枢纽分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.507.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:22:09","updateId":1,"updatetime":"2018-07-13 18:22:09","sn":13,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}},"ddNo":"","lineMoney":"1","lineMile":"15.8","yyCar":"24","memo":"","lineType":"","smz":"火车站\u2014\u2014鼓楼路口"}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * lineInfoId : 55375
         * lineCode : 11
         * lineName : 11路
         * depId : null
         * department : {"version":null,"orgId":null,"orgPath":null,"depId":505,"depName":"营运一分公司","depDesc":"","depLevel":2,"parentId":378,"path":"0.378.505.","orgType":2,"creatorId":1,"createtime":"2018-07-13 18:21:21","updateId":1,"updatetime":"2018-07-13 18:21:21","sn":11,"chargeIds":"","chargeNames":"","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
         * ddNo :
         * lineMoney : 1
         * lineMile : 24.5
         * yyCar : 51
         * memo :
         * lineType :
         * smz : 高士北路口——泰极驾校
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int lineInfoId;
        private String lineCode;
        private String lineName;
        private Object depId;
        private DepartmentBean department;
        private String ddNo;
        private String lineMoney;
        private String lineMile;
        private String yyCar;
        private String memo;
        private String lineType;
        private String smz;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getLineInfoId() {
            return lineInfoId;
        }

        public void setLineInfoId(int lineInfoId) {
            this.lineInfoId = lineInfoId;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public Object getDepId() {
            return depId;
        }

        public void setDepId(Object depId) {
            this.depId = depId;
        }

        public DepartmentBean getDepartment() {
            return department;
        }

        public void setDepartment(DepartmentBean department) {
            this.department = department;
        }

        public String getDdNo() {
            return ddNo;
        }

        public void setDdNo(String ddNo) {
            this.ddNo = ddNo;
        }

        public String getLineMoney() {
            return lineMoney;
        }

        public void setLineMoney(String lineMoney) {
            this.lineMoney = lineMoney;
        }

        public String getLineMile() {
            return lineMile;
        }

        public void setLineMile(String lineMile) {
            this.lineMile = lineMile;
        }

        public String getYyCar() {
            return yyCar;
        }

        public void setYyCar(String yyCar) {
            this.yyCar = yyCar;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getLineType() {
            return lineType;
        }

        public void setLineType(String lineType) {
            this.lineType = lineType;
        }

        public String getSmz() {
            return smz;
        }

        public void setSmz(String smz) {
            this.smz = smz;
        }

        public static class DepartmentBean  implements Serializable{
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * depId : 505
             * depName : 营运一分公司
             * depDesc :
             * depLevel : 2
             * parentId : 378
             * path : 0.378.505.
             * orgType : 2
             * creatorId : 1
             * createtime : 2018-07-13 18:21:21
             * updateId : 1
             * updatetime : 2018-07-13 18:21:21
             * sn : 11
             * chargeIds :
             * chargeNames :
             * demension : {"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int depId;
            private String depName;
            private String depDesc;
            private int depLevel;
            private int parentId;
            private String path;
            private int orgType;
            private int creatorId;
            private String createtime;
            private int updateId;
            private String updatetime;
            private int sn;
            private String chargeIds;
            private String chargeNames;
            private DemensionBean demension;

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }

            public Object getOrgId() {
                return orgId;
            }

            public void setOrgId(Object orgId) {
                this.orgId = orgId;
            }

            public Object getOrgPath() {
                return orgPath;
            }

            public void setOrgPath(Object orgPath) {
                this.orgPath = orgPath;
            }

            public int getDepId() {
                return depId;
            }

            public void setDepId(int depId) {
                this.depId = depId;
            }

            public String getDepName() {
                return depName;
            }

            public void setDepName(String depName) {
                this.depName = depName;
            }

            public String getDepDesc() {
                return depDesc;
            }

            public void setDepDesc(String depDesc) {
                this.depDesc = depDesc;
            }

            public int getDepLevel() {
                return depLevel;
            }

            public void setDepLevel(int depLevel) {
                this.depLevel = depLevel;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getOrgType() {
                return orgType;
            }

            public void setOrgType(int orgType) {
                this.orgType = orgType;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public int getUpdateId() {
                return updateId;
            }

            public void setUpdateId(int updateId) {
                this.updateId = updateId;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getChargeIds() {
                return chargeIds;
            }

            public void setChargeIds(String chargeIds) {
                this.chargeIds = chargeIds;
            }

            public String getChargeNames() {
                return chargeNames;
            }

            public void setChargeNames(String chargeNames) {
                this.chargeNames = chargeNames;
            }

            public DemensionBean getDemension() {
                return demension;
            }

            public void setDemension(DemensionBean demension) {
                this.demension = demension;
            }

            public static class DemensionBean  implements Serializable{
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * demId : 1
                 * demName : 行政维度
                 * demDesc : 行政维度
                 * demType : 1
                 */

                private Object version;
                private Object orgId;
                private Object orgPath;
                private int demId;
                private String demName;
                private String demDesc;
                private int demType;

                public Object getVersion() {
                    return version;
                }

                public void setVersion(Object version) {
                    this.version = version;
                }

                public Object getOrgId() {
                    return orgId;
                }

                public void setOrgId(Object orgId) {
                    this.orgId = orgId;
                }

                public Object getOrgPath() {
                    return orgPath;
                }

                public void setOrgPath(Object orgPath) {
                    this.orgPath = orgPath;
                }

                public int getDemId() {
                    return demId;
                }

                public void setDemId(int demId) {
                    this.demId = demId;
                }

                public String getDemName() {
                    return demName;
                }

                public void setDemName(String demName) {
                    this.demName = demName;
                }

                public String getDemDesc() {
                    return demDesc;
                }

                public void setDemDesc(String demDesc) {
                    this.demDesc = demDesc;
                }

                public int getDemType() {
                    return demType;
                }

                public void setDemType(int demType) {
                    this.demType = demType;
                }
            }
        }
    }
}

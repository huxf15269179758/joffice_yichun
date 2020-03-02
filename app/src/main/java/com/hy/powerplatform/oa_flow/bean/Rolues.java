package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/3/6.
 */

public class Rolues implements Serializable {

    /**
     * defId : 10117
     * proType : 行政管理
     * name : 中层领导请假单
     * description : 中层领导请假单
     * createtime : 2018-12-26 18:06:56.433
     * deployId : 6210061
     * newVersion : 2
     * status : 1
     * drawDefXml : <diagram xmlns:bg="bpm.graphic" xmlns:ciied="com.ibm.ilog.elixir.diagram" xmlns:fg="flash.geom">
     <bg:StartEvent id="startEvent1" height="51" width="36" x="440" y="40">
     <label>开始</label>
     <ports>
     <ciied:Port id="port1" clipOnShape="true" movable="false"/>
     <ciied:Port id="port2" y="1"/>
     <ciied:Port id="port3" clipOnShape="true" movable="false"/>
     <ciied:Port id="port4" clipOnShape="true" movable="false">
     <id>CENTER</id>
     </ciied:Port>
     </ports>
     </bg:StartEvent>
     <bg:Task id="task1" height="50" user="true" width="90" x="410" y="130">
     <expression></expression>
     <label>分管领导</label>
     <ports>
     <ciied:Port id="port5" clipOnShape="true" movable="false"/>
     <ciied:Port id="port6" y="0"/>
     <ciied:Port id="port7" y="1"/>
     <ciied:Port id="port8" x="0"/>
     <ciied:Port id="port9" clipOnShape="true" movable="false"/>
     <ciied:Port id="port10" clipOnShape="true" movable="false">
     <id>CENTER</id>
     </ciied:Port>
     </ports>
     </bg:Task>
     <bg:Task id="task2" height="50" user="true" width="90" x="410" y="210">
     <expression></expression>
     <label>总经理</label>
     <ports>
     <ciied:Port id="port11" clipOnShape="true" movable="false"/>
     <ciied:Port id="port12" y="0"/>
     <ciied:Port id="port13" y="1"/>
     <ciied:Port id="port14" x="0"/>
     <ciied:Port id="port15" clipOnShape="true" movable="false"/>
     <ciied:Port id="port16" clipOnShape="true" movable="false">
     <id>CENTER</id>
     </ciied:Port>
     </ports>
     </bg:Task>
     <bg:Task id="task3" height="50" user="true" width="90" x="410" y="310">
     <expression></expression>
     <label>人力资源部</label>
     <ports>
     <ciied:Port id="port17" clipOnShape="true" movable="false"/>
     <ciied:Port id="port18" y="0"/>
     <ciied:Port id="port19" y="1"/>
     <ciied:Port id="port20" clipOnShape="true" movable="false"/>
     <ciied:Port id="port21" clipOnShape="true" movable="false">
     <id>CENTER</id>
     </ciied:Port>
     </ports>
     </bg:Task>
     <bg:EndEvent id="endEvent1" height="51" width="36" x="440" y="410">
     <label>结束1</label>
     <ports>
     <ciied:Port id="port22" clipOnShape="true" movable="false"/>
     <ciied:Port id="port23" y="0"/>
     <ciied:Port id="port24" clipOnShape="true" movable="false"/>
     <ciied:Port id="port25" x="0"/>
     <ciied:Port id="port26" verticalOffset="-5" x="0"/>
     <ciied:Port id="port27" clipOnShape="true" movable="false">
     <id>CENTER</id>
     </ciied:Port>
     </ports>
     </bg:EndEvent>
     <bg:SequenceFlow id="sequenceFlow1" endPort="port6" startPort="port2">
     <fallbackEndPoint>
     <fg:Point id="point1" x="456" y="123"/>
     </fallbackEndPoint>
     <fallbackStartPoint>
     <fg:Point id="point2"/>
     </fallbackStartPoint>
     <label>to 分管领导</label>
     </bg:SequenceFlow>
     <bg:SequenceFlow id="sequenceFlow2" endPort="port12" startPort="port7">
     <fallbackEndPoint>
     <fg:Point id="point3" x="452" y="226"/>
     </fallbackEndPoint>
     <fallbackStartPoint>
     <fg:Point id="point4"/>
     </fallbackStartPoint>
     <label>to 总经理</label>
     </bg:SequenceFlow>
     <bg:SequenceFlow id="sequenceFlow3" endPort="port18" startPort="port13">
     <fallbackEndPoint>
     <fg:Point id="point5" x="440" y="331"/>
     </fallbackEndPoint>
     <fallbackStartPoint>
     <fg:Point id="point6"/>
     </fallbackStartPoint>
     <label>to 人力资源部</label>
     </bg:SequenceFlow>
     <bg:SequenceFlow id="sequenceFlow4" endPort="port23" startPort="port19">
     <fallbackEndPoint>
     <fg:Point id="point7" x="447" y="439"/>
     </fallbackEndPoint>
     <fallbackStartPoint>
     <fg:Point id="point8"/>
     </fallbackStartPoint>
     <label>to 结束1</label>
     </bg:SequenceFlow>
     </diagram>
     */

    private String defId;
    private String proType;
    private String name;
    private String description;
    private String createtime;
    private String deployId;
    private String newVersion;
    private String status;
    private String drawDefXml;

    public String getDefId() {
        return defId;
    }

    public void setDefId(String defId) {
        this.defId = defId;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDeployId() {
        return deployId;
    }

    public void setDeployId(String deployId) {
        this.deployId = deployId;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDrawDefXml() {
        return drawDefXml;
    }

    public void setDrawDefXml(String drawDefXml) {
        this.drawDefXml = drawDefXml;
    }
}

package com.fangxi.service;

import com.fangxi.domain.Architect;
import com.fangxi.domain.Designer;
import com.fangxi.domain.Employee;
import com.fangxi.domain.Programmer;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-08 14:22
 */
public class TeamService {
    private int memberTmpId = 1;
    private static final int MAX_MEMBER = 6;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;
    private int proNum = 0;
    private int desNum = 0;
    private int arcNum = 0;

    public Programmer[] getTeam() {
        Programmer[] realTeam = new Programmer[total];
        for (int i = 0; i < total; i++) {
            realTeam[i] = team[i];
        }
        return realTeam;
    }

    public int getTeamNum() {
        return total;
    }

    public void addTeamMember(Employee e) throws TeamException {
//        成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        //转为程序员类型
        Programmer member = (Programmer) e;

//       该员工已在本开发团队中
        if (member.getMemberId() != 0) {
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员
        if (member.getStatus().equals("BUSY")) {
            throw new TeamException(" 该员工已属于其它团队");
        }
//        该员正在休假，无法添加
        if (member.getStatus().equals("VOCATION")) {
            throw new TeamException("该员正在休假，无法添加");
        }
//        团队中至多只能有一名架构师
        if (e instanceof Architect) {
            if (arcNum >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            } else {
                arcNum++;
            }
        }
//        团队中至多只能有两名设计师
        else if (e instanceof Designer) {
            if (desNum >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            } else {
                desNum++;
            }
        }
//        团队中至多只能有三名程序员
        else {
            if (proNum >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            } else {
                proNum++;
            }
        }
        team[total++] = member;
        member.setMemberId(memberTmpId++);
    }

    //3-删除团队成员
    public void removeTeamMember(int id) throws TeamException {

        for (int i = 0; i < total; i++) {
            if(team[i].getMemberId()==id){
                team[i].setStatus(Status.FREE);
                for (int j = i; j <total ; j++) {
                    team[i] = team[i + 1];
                }
                total--;
                return;
            }

        }
        // 找不到指定memberId的员工，删除失败
        throw new TeamException("找不到指定memberId的员工，删除失败");
    }
}

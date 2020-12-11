package com.fangxi.view;

import com.fangxi.domain.Employee;
import com.fangxi.domain.Programmer;
import com.fangxi.service.NameListService;
import com.fangxi.service.TeamException;
import com.fangxi.service.TeamService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:48
 */
public class TeamView {
    NameListService nameListService = new NameListService();
    TeamService teamService = new TeamService();
    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        List<String> list = new ArrayList<String>();
        teamView.startTeamView();
    }
    //0-启动
    public void startTeamView() {
        char choose = '0';
        boolean loopFlag = true;

        do {
            if (choose != '1') {
                showEmployeeList();
            }
            System.out.print("----------------------------------------------------------------------------------------------\n" +
                    "1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            choose = TSUtility.readMenuSelection();
            switch (choose) {
                case '1':
                    showTeamList();
                    break;
                case '2':
                    addTeamMember();
                    break;
                case '3':
                    deleteTeamMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        } while (loopFlag);
        System.out.println("成功退出 ");
    }

    //0-员工队列表
    public void showEmployeeList() {
//        当选择“团队列表”菜单时，先列出所有员工
        System.out.println("---------------------------------------开发团队调度软件----------------------------------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        Employee[] employees = nameListService.getAllEmployees();
        for (Employee s : employees) {
            System.out.println(s);
        }

    }

    //1-开发团队列表
    public void showTeamList() {
        Programmer[] team = teamService.getTeam();
        if (teamService.getTeamNum() > 0) {
            System.out.println("-----------------------------------团队成员列表----------------------------------\n");
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (Programmer p : team) {
                System.out.println(p.getDetailsOfTeam());
            }
        } else {
            System.out.println("----------------------------------团队暂时没有成员------------------------------------\n");
        }
    }

    //2-添加团队成员
    public void addTeamMember() {
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee e = nameListService.getEmployee(id);
            teamService.addTeamMember(e);
        } catch (TeamException teamException) {
            System.out.println("添加失败，失败原因：" + teamException.getMessage());
            TSUtility.readReturn();
        }

    }


    //3-删除团队成员
    public void deleteTeamMember() {
        System.out.print("请输入要删除的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        if (TSUtility.readConfirmSelection() == 'N') return;
        try {
            teamService.removeTeamMember(id);
        } catch (TeamException teamException) {
            System.out.println("删除失败，失败原因：" + teamException.getMessage());
            TSUtility.readReturn();
        }
    }


}
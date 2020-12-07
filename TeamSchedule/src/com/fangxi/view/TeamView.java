package com.fangxi.view;

import com.fangxi.domain.Employee;
import com.fangxi.service.NameListService;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:48
 */
public class TeamView {
    NameListService nameListService = new NameListService();
    Employee[] employees=nameListService.getAllEmployees();
    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.showTeamList();
    }

    //0-启动
    public void startTeamView() {
        char choose;
        boolean loopFlag = true;
        do {
            showTeamList();
            System.out.println("----------------------------------------------------------------------------------------------\n" +
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
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        } while (loopFlag);
    }

    //1-团队列表
    public void showTeamList() {
//        当选择“团队列表”菜单时，先列出所有员工

        System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
        System.out.println("ID\t\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
        for (Employee s:employees){
            System.out.println(s.toString());
        }
//        再列出开发团队中的现有成员，例如：


    }

    //2-添加团队成员
    public void addTeamMember() {
//        成员已满，无法添加
//        该成员不是开发人员，无法添加
//        该员工已在本开发团队中
//        该员工已是某团队成员
//        该员正在休假，无法添加
//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员

    }

    //3-删除团队成员
    public void deleteTeamMember() {
//        请输入要删除员工的TID：1
//        确认是否删除(Y/N)：y
//        删除成功
//        按回车键继续...
//        删除成功后，按回车键将重新显示主界面。
    }


}
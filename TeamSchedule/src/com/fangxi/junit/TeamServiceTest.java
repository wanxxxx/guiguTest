package com.fangxi.junit;

import com.fangxi.domain.Employee;
import com.fangxi.service.NameListService;
import com.fangxi.service.TeamException;
import com.fangxi.service.TeamService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-08 14:59
 */
public class TeamServiceTest {
    TeamService teamService = new TeamService();
    Employee[] employees = new NameListService().getAllEmployees();

    @Test
    public void getTeam() {
    }

    @Test
    public void addTeamMember() {
        try {
            teamService.addTeamMember(employees[0]);
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTeamMember() {
    }
}
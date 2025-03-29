package com.genie.Train.controller;
import java.util.List;
import com.genie.Train.Entity.Station;
import com.genie.Train.Entity.Train;
import com.genie.Train.Entity.TrainSchedule;
import com.genie.Train.repo.StationRepository;
import com.genie.Train.repo.TrainRepository;
import com.genie.Train.repo.TrainScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/test")
@RestController
public class Test {

    @Autowired
    StationRepository stationRepository;


    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TrainScheduleRepository trainScheduleRepository;
    @GetMapping
    public void test(){
        Station delhi = new Station(null,"New Delhi","NDLS");
        Station mumbai = new Station(null,"Mumbai Central","CST");
        Station chennai = new Station(null,"Chennai Central","MAS");
        Station kolkata = new Station(null,"Kolkata","KOAA");


        stationRepository.saveAll(List.of(delhi,mumbai,chennai,kolkata));


        Train rajdhani = new Train(null,"Rajdhani Express","12306",null);
        Train durunto = new Train(null,"durunto Express","12266",null);
        Train shtabdi = new Train(null,"shtabdi Express","12043",null);

        trainRepository.saveAll(List.of(rajdhani, durunto , shtabdi ));

        TrainSchedule sc1 = new TrainSchedule(null,rajdhani,delhi,mumbai,"06:00","14:00");
        TrainSchedule sc2= new TrainSchedule(null,durunto,mumbai,kolkata,"08:00","21:00");
        TrainSchedule sc3 = new TrainSchedule(null,shtabdi,kolkata,chennai,"11:00","19:00");
        

        trainScheduleRepository.saveAll(List.of(sc1,sc2,sc3));

        System.out.println("Data inserted in Database.........");


    }



}

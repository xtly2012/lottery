create table lottery_ticket
(
     lottery_run_time date,
     lottery_period_num int(7),
     lottery_red_first varchar(4),
     lottery_red_second varchar(4),
     lottery_red_third varchar(4),
     lottery_red_fourth varchar(4),
     lottery_red_fifth varchar(4),
     lottery_red_sixth varchar(4),
     lottery_blue_first varchar(4),
     lottery_sale_volume int(10),
     primary key (lottery_period_num)
);

create table lottery_init_time
(
	lottery_init_time date,
	primary key (lottery_init_time)
);
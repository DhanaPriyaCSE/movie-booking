select * from Seatmanagement

alter table Confirmation drop column Sequenceno

alter table Confirmation drop constraint FK__Confirmat__Seque__6383C8BA

alter table Confirmation drop Sequenceno

alter table TimingTable drop column FN

alter table TimingTable add showdate varchar(20)

insert into TimingTable values('2R2C4','T2','pachai','M3','1.00-3.30','06-06-19')

update TimingTable set Timing='4.00-6.30',showdate='5-06-19' where Sequenceno='3'

select * from TimingTable
select * from Seatmanagement

alter table TimingTable alter column showdate varchar(20) not null;


--to see available seats

select * from Seatmanagement T

left join


(select B.SeatID, B.TheatreID, B.Timing, A.showdate,A.MovieID from 
[Seatmanagement] B  left join TimingTable A on B.SeatID=A.SeatID and B.TheatreID=A.TheatreID and b.Timing=A.Timing
where --showdate is  null AND
 --A.showdate='06-06-19' and 
 B.Timing='1.00-3.30'  and B.TheatreID='T2' and A.MovieID='M4')Booked

 on T.SeatID=Booked.SeatID and T.TheatreID=Booked.TheatreID and T.Timing=Booked.Timing
 
 
 
 
 where Booked.MovieID is null and  T.Timing='1.00-3.30'  and T.TheatreID='T2' --and Booked.MovieID='M3'





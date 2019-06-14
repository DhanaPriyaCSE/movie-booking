select C.userid,C.TheatreID,Th.TheatreName,U.userName,C.BookingID from Confirmation C
join usertable U on U.userid=C.userid
join Theatre Th on Th.TheatreID=C.TheatreID
where C.userid='pachai'

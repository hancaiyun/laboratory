/*管理员*/
select * from user

INSERT INTO user VALUES('ret','韩才运','123','男','学生','18672056943')

select *from user where user_id like '%03124%'

select *from notice;
create  index notice_index on notice (notice_id);
insert  into notice values(1002,'测试一下，看能不能插入汉字，卧槽，能啊！！！');


select *from admin
INSERT INTO admin VALUES('admin','cocky','admin','','','')
delete from user where user_id='admin'

delete from user
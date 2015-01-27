DELIMITER $$

DROP PROCEDURE IF EXISTS `userdb`.`GetListUsers` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetListUsers`()
BEGIN
select * from user;
END $$

DELIMITER ;
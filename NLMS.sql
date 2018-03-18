CREATE SCHEMA testnlms AUTHORIZATION apssdc;


CREATE TABLE testnlms.users
(
  id serial PRIMARY KEY,
  username character varying UNIQUE,
  password character varying NOT NULL,
  name character varying,
  status boolean,
  role character varying,
  mandal character varying,
  district character varying,
  logtime timestamp without time zone DEFAULT now(),
  ipaddress character varying,
  loguser character varying
);

CREATE TABLE testnlms.logins (
    username character varying NOT NULL,
    context character varying,
    logtime timestamp with time zone
);

INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ada.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Adavidevulapalli', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ada.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Adavidevulapalli', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.anu.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Anumula (Haliya)', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.anu.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Anumula (Haliya)', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.cha.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Chandampeta, Chandur', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.cha.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Chandampeta, Chandur', 'Nalgonda');
--INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.cha.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Chandur', 'Nalgonda');
--INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.cha.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Chandur', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.chi.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Chinthapally, Chityal', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.chi.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Chinthapally, Chityal', 'Nalgonda');
--INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.chi.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Chityal', 'Nalgonda');
--INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.chi.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Chityal', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.dam.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Dameracherla', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.dam.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Dameracherla', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.dev.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Devarakonda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.dev.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Devarakonda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.gun.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Gundlapally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.gun.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Gundlapally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.gur.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Gurrampode', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.gur.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Gurrampode', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.kan.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Kanagal', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.kan.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Kanagal', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.kat.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Kattangur', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.kat.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Kattangur', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ket.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Kethepally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ket.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Kethepally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.kon.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Konda Mallepally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.kon.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Konda Mallepally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mad.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Madugulapalli', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mad.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Madugulapalli', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mar.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Marriguda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mar.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Marriguda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mir.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Miryalaguda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mir.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Miryalaguda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mun.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Munugode', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.mun.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Munugode', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nak.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Nakrekal', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nak.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Nakrekal', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nal.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Nalgonda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nal.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Nalgonda', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nam.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Nampally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nam.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Nampally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nar.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Narketpally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nar.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Narketpally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ner.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Neredugommu', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ner.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Neredugommu', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nid.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Nidmanoor', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.nid.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Nidmanoor', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ped.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Pedda Adesherlapally, Peddavoora', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ped.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Pedda Adesherlapally, Peddavoora', 'Nalgonda');
--INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ped.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Peddavoora', 'Nalgonda');
--INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.ped.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Peddavoora', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.sha.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Shaligouraram', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.sha.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Shaligouraram', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.thi.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Thipparthy', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.thi.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Thipparthy', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.tir.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Tirumalagiri Sagar', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.tir.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Tirumalagiri Sagar', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.tri.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Tripuraram', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.tri.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Tripuraram', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.vem.01', '-SWRbidU5eA_dd1YpXMyUQ', 'Vemulapally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('vas.nal.vem.02', '-SWRbidU5eA_dd1YpXMyUQ', 'Vemulapally', 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('do.nal.01', '-SWRbidU5eA_dd1YpXMyUQ', null, 'Nalgonda');
INSERT INTO testnlms.users(username, password, mandal, district) VALUES ('do.nal.02', '-SWRbidU5eA_dd1YpXMyUQ', null, 'Nalgonda');



CREATE TABLE testnlms.dvaho
( 
	id serial PRIMARY KEY,
	benificiaryName character varying,
	fatherName character varying,
	village character varying,
	mandal character varying,
	proceedingNo character varying,
	siNoOfTheProceeding character varying,
	dateOfGrounding character varying,
	placeOfGrounding character varying,
	sellerName character varying,
	sellerFatherOrHusbandName character varying,
	sellerAddress character varying,
	sellerAadhar character varying,
	sellerAccountNumber character varying,
	amountPaid character varying,
	chequeNoIssuedByTheDVAHO character varying,
	date character varying
)


UPDATE testnlms.aug SET sellerAadhar = REPLACE(sellerAadhar, ' ', '');

INSERT INTO testnlms.dvaho(
            benificiaryname, fathername, village, mandal, proceedingno, 
            sinooftheproceeding, dateofgrounding, placeofgrounding, sellername, 
            sellerfatherorhusbandname, selleraddress, selleraadhar, selleraccountnumber, 
            amountpaid, chequenoissuedbythedvaho, date)
(SELECT benificiaryname, fathername, village, mandal, proceedingno, 
       sinooftheproceeding, dateofgrounding, placeofgrounding, sellername, 
       sellerfatherorhusbandname, selleraddress, selleraadhar, selleraccountnumber, 
       amountpaid, chequenoissuedbythedvaho, date
  FROM testnlms.aug);


 CREATE TABLE testnlms.sanctioned_beneficiary_details
(
	id serial PRIMARY KEY,
	sanctionOderId character varying,
	farmerId character varying,
	name character varying,
	fatherOrHusbandName character varying,
	aadhaar character varying,
	unitCost character varying,
	subsidy	character varying,
	benificiaryContrib character varying,
	year character varying,
	village	character varying,
	mandal character varying,
	district character varying,
	department character varying,
	schemeName character varying
)


UPDATE testnlms.csv_sanctioned_beneficiary_details SET year = '2017-18', department = 'Animal Husbandry', schemeName='Sheep'

  INSERT INTO testnlms.sanctioned_beneficiary_details(
            sanctionoderid, farmerid, name, fatherorhusbandname, aadhaar, 
            unitcost, subsidy, benificiarycontrib, year, village, mandal, 
            district, department, schemename) 
(SELECT sanctionoderid, farmerid, name, fatherorhusbandname, aadhaar, 
       unitcost, subsidy, benificiarycontrib, year, village, mandal, 
       district, department, schemename
  FROM testnlms.csv_sanctioned_beneficiary_details)

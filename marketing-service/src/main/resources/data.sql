Insert into ASSIGNED_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (1,'تخصیص یافته به شعبه','AST1');
Insert into ASSIGNED_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (2,'افتتاح حساب','AST2');
Insert into ASSIGNED_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (3,'در انتظار کمیته وام','AST3');
Insert into ASSIGNED_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (4,'صدور دسته چک','AST4');


Insert into ATTRACTION_TYPES (ID,TYPE_NAME,TYPE_CODE) values (1,'بالقوه','AT1');
Insert into ATTRACTION_TYPES (ID,TYPE_NAME,TYPE_CODE) values (2,'راغب','AT2');
Insert into ATTRACTION_TYPES (ID,TYPE_NAME,TYPE_CODE) values (3,'در حال جذب','AT3');


Insert into BUSINESS_SCALES (ID,BUSINESS_SCALE_NAME) values (1,'شرکت بزرگ');
Insert into BUSINESS_SCALES (ID,BUSINESS_SCALE_NAME) values (2,'شرکت متوسط و کوچک');
Insert into BUSINESS_SCALES (ID,BUSINESS_SCALE_NAME) values (3,'موسسه غیردولتی');
Insert into BUSINESS_SCALES (ID,BUSINESS_SCALE_NAME) values (4,'نهاد دولتی');
Insert into BUSINESS_SCALES (ID,BUSINESS_SCALE_NAME) values (5,'مغازه بزرگ/کوچک');
Insert into BUSINESS_SCALES (ID,BUSINESS_SCALE_NAME) values (6,'ویلا/آپارتمان');


Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (1,'مدیرعامل');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (2,'هیات مدیره');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (3,'معاون مالی');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (4,'معاون بازاریابی');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (5,'مدیریت');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (6,'مالک');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (7,'نماینده');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (8,'مدیرامور');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (9,'مدیرمالی');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (10,'سرپرستی');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (11,'رییس شعبه');
Insert into CONTACT_ROLES (ID,CONTACT_ROLE_NAME) values (12,'معاون شعبه');

Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (1,0,'موبایل');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (2,0,'ثابت');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (3,0,'کار');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (4,0,'منزل');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (5,0,'فکس');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (6,1,'پست الکترونیک شخصی');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (7,1,'پست الکترونیک کاری');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (8,2,'تلگرام');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (9,2,'اینستاگرام');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (10,2,'فیسبوک');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (11,2,'توییتر');
Insert into CONTACT_TYPES (ID,TYPE_CATEGORY,TYPE_NAME) values (12,2,'واتس آپ');

Insert into DOCUMENT_TYPES (ID,TYPE_NAME) values (1,'doc type 1');
Insert into DOCUMENT_TYPES (ID,TYPE_NAME) values (2,'doc type 2');

Insert into ORGANIZATION_TYPES (ID,TYPE_NAME) values (1,'سهامی عام');
Insert into ORGANIZATION_TYPES (ID,TYPE_NAME) values (2,'سهامی خاص');
Insert into ORGANIZATION_TYPES (ID,TYPE_NAME) values (3,'نهاد دولتی');
Insert into ORGANIZATION_TYPES (ID,TYPE_NAME) values (4,'موسسه غیر دولتی');

Insert into OWNERSHIP_TYPES (ID,TYPE_NAME) values (1,'مالک');
Insert into OWNERSHIP_TYPES (ID,TYPE_NAME) values (2,'مستاجر');

Insert into REQUIREMENT_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (1,'تعریف نیاز','RS1');
Insert into REQUIREMENT_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (2,'در حال تصویب','RS2');
Insert into REQUIREMENT_STATUS_TYPES (ID,TYPE_NAME,TYPE_CODE) values (3,'امضا','RS3');

Insert into VALUE_TYPES (ID,TYPE_NAME) values (1,'روز');
Insert into VALUE_TYPES (ID,TYPE_NAME) values (2,'ماه');
Insert into VALUE_TYPES (ID,TYPE_NAME) values (3,'سال');

Insert into ORGANS (ID,ORGAN_LEVEL,ORGAN_NAME,ORGAN_ORDER,PARENT_ID) values (1,0,'شعب تهران',0,null);
Insert into ORGANS (ID,ORGAN_LEVEL,ORGAN_NAME,ORGAN_ORDER,PARENT_ID) values (2,0,'شعب غرب',0,1);
Insert into ORGANS (ID,ORGAN_LEVEL,ORGAN_NAME,ORGAN_ORDER,PARENT_ID) values (3,0,'شعب شرق',0,1);



Insert into PERSONNELS (ID,PERSONNEL_NAME,REGISTER_DATE,USER_NAME,ORGAN_ID) values (1,'مرتضی',to_timestamp('24-JAN-19 03.27.51.293000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'morteza',1);
Insert into PERSONNELS (ID,PERSONNEL_NAME,REGISTER_DATE,USER_NAME,ORGAN_ID) values (2,'سارا',to_timestamp('24-JAN-19 03.27.51.293000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'sara',1);
Insert into PERSONNELS (ID,PERSONNEL_NAME,REGISTER_DATE,USER_NAME,ORGAN_ID) values (3,'داریوش',to_timestamp('24-JAN-19 03.27.51.293000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'dariush',2);
Insert into PERSONNELS (ID,PERSONNEL_NAME,REGISTER_DATE,USER_NAME,ORGAN_ID) values (4,'رضا',to_timestamp('24-JAN-19 03.27.51.293000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'reza',2);



Insert into TEAMS (ID,TEAM_NAME,REGISTER_DATE,ORGAN_ID) values (1,'بازاریابی خارج شعبه',to_timestamp('23-JAN-19 03.19.33.401000000 PM','DD-MON-RR HH.MI.SSXFF AM'),2);

Insert into TEAMS_MEMBERS (ID,MEMBERSHIP_DATE,MEMBERSHIP_STATUS,PERSONNEL_ID,TEAM_ID) values (1,to_timestamp('24-JAN-19 03.46.41.139000000 PM','DD-MON-RR HH.MI.SSXFF AM'),1,1,1);
Insert into TEAMS_MEMBERS (ID,MEMBERSHIP_DATE,MEMBERSHIP_STATUS,PERSONNEL_ID,TEAM_ID) values (2,to_timestamp('24-JAN-19 03.46.41.139000000 PM','DD-MON-RR HH.MI.SSXFF AM'),1,2,1);

Insert into SERVICES (ID,SERVICE_NAME,PARENT_ID) values (1,'قرض الحسنه',null);
Insert into SERVICES (ID,SERVICE_NAME,PARENT_ID) values (2,'تسهیلات مضاربه',null);





Insert into TARGETS (ID,START_DATE,DUE_DATE,TARGET_NAME,REGISTER_DATE,TARGET_VALUE,ORGAN_ID,SERVICE_ID,VALUE_TYPE_ID,DAYS_COUNT) values (1,to_timestamp('10-MAY-18 03.22.23.546000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('10-MAY-19 03.22.23.546000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'جذب سرمایه',to_timestamp('23-JAN-19 03.23.19.537000000 PM','DD-MON-RR HH.MI.SSXFF AM'),100000000000,2,1,1,180);
Insert into TARGETS (ID,START_DATE,DUE_DATE,TARGET_NAME,REGISTER_DATE,TARGET_VALUE,ORGAN_ID,SERVICE_ID,VALUE_TYPE_ID,DAYS_COUNT) values (2,to_timestamp('10-MAY-18 03.41.35.490000000 PM','DD-MON-RR HH.MI.SSXFF AM'),to_timestamp('10-MAY-19 03.41.35.490000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'اعطای تسهیلات مضاربه',to_timestamp('23-JAN-19 03.42.11.674000000 PM','DD-MON-RR HH.MI.SSXFF AM'),800000000,2,2,1,60);

Insert into TARGETS_MEMBERS (ID,TARGET_MEMBER_VALUE,DUE_DATE,TARGET_MEMBER_NAME,REGISTER_DATE,TARGET_ID,VALUE_TYPE_ID,TEAM_MEMBER_ID) values (1,50000000000,to_timestamp('20-OCT-19 03.26.51.064000000 PM','DD-MON-RR HH.MI.SSXFF AM'),null,to_timestamp('23-JAN-19 03.27.17.701000000 PM','DD-MON-RR HH.MI.SSXFF AM'),1,1,2);
Insert into TARGETS_MEMBERS (ID,TARGET_MEMBER_VALUE,DUE_DATE,TARGET_MEMBER_NAME,REGISTER_DATE,TARGET_ID,VALUE_TYPE_ID,TEAM_MEMBER_ID) values (2,400000000,to_timestamp('20-OCT-19 03.43.12.425000000 PM','DD-MON-RR HH.MI.SSXFF AM'),null,to_timestamp('23-JAN-19 03.43.25.722000000 PM','DD-MON-RR HH.MI.SSXFF AM'),2,1,2);



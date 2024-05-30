--itsuテーブル
INSERT INTO itsu(id,TEXT,user_name,add_date)
VALUES(1,'夜な夜な','Aチーム',current_date);
INSERT INTO itsu(id,TEXT,user_name,add_date)
VALUES(2,'遠い未来','未来人',current_date);
INSERT INTO itsu(id,TEXT,user_name,add_date)
VALUES(3,'さっき','中川',current_date);
INSERT INTO itsu(id,TEXT,user_name,add_date)
VALUES(4,'ちょうど1年前に','ジョージ',current_date);
INSERT INTO itsu(id,TEXT,user_name,add_date)
VALUES(5,'学生の時','こぶた',current_date);

--dokodeテーブル
INSERT INTO dokode(id,TEXT,user_name,add_date)
VALUES(1,'国際宇宙ステーション','Aチーム',current_date);
INSERT INTO dokode(id,TEXT,user_name,add_date)
VALUES(2,'夏の甲子園準決勝の舞台','球児',current_date);
INSERT INTO dokode(id,TEXT,user_name,add_date)
VALUES(3,'仮想空間','天才SE',current_date);
INSERT INTO dokode(id,TEXT,user_name,add_date)
VALUES(4,'渋谷のスクランブル交差点','ほいける',current_date);
INSERT INTO dokode(id,TEXT,user_name,add_date)
VALUES(5,'遊園地','たぬき',current_date);

--daregaテーブル
INSERT INTO darega(id,TEXT,user_name,add_date)
VALUES(1,'赤ちゃんが','Aチーム',current_date);
INSERT INTO darega(id,TEXT,user_name,add_date)
VALUES(2,'宇宙人','火星人',current_date);
INSERT INTO darega(id,TEXT,user_name,add_date)
VALUES(3,'そこまで悪くない越後屋','ぷす',current_date);
INSERT INTO darega(id,TEXT,user_name,add_date)
VALUES(4,'敏腕プロデューサー','オクトパス',current_date);
INSERT INTO darega(id,TEXT,user_name,add_date)
VALUES(5,'店長','B',current_date);

--naniwoテーブル
INSERT INTO naniwo(id,TEXT,user_name,add_date)
VALUES(1,'からあげを大量に食べた','Aチーム',current_date);
INSERT INTO naniwo(id,TEXT,user_name,add_date)
VALUES(2,'取り返しのつかないことをした','ヤバみ',current_date);
INSERT INTO naniwo(id,TEXT,user_name,add_date)
VALUES(3,'バンジージャンプをした','怖がりさん',current_date);
INSERT INTO naniwo(id,TEXT,user_name,add_date)
VALUES(4,'昼寝した','さいとう',current_date);
INSERT INTO naniwo(id,TEXT,user_name,add_date)
VALUES(5,'ゲーム大会をした','名無し',current_date);

--kanseiテーブル
INSERT INTO kansei(id,TEXT,create_user,add_date,good)
VALUES(1,'夜な夜な,国際宇宙ステーションで赤ちゃんがからあげを大量に食べた','Aチーム',current_date,65);
INSERT INTO kansei(id,TEXT,create_user,add_date,good)
VALUES(2,'遠い未来,夏の甲子園準決勝の舞台で宇宙人が取り返しのつかないことをした','未来人,球児,火星人,ヤバみ',current_date,87);
INSERT INTO kansei(id,TEXT,create_user,add_date,good)
VALUES(3,'さっき,仮想空間でそこまで悪くない越後屋がバンジージャンプをした','中川,天才SE,火星人,怖がりさん',current_date,90);
INSERT INTO kansei(id,TEXT,create_user,add_date,good)
VALUES(4,'ちょうど1年前に,渋谷のスクランブル交差点で敏腕プロデューサーが昼寝した','ジョージ,ほいける,オクトパス,さいとう',current_date,33);
INSERT INTO kansei(id,TEXT,create_user,add_date,good)
VALUES(5,'学生の時,遊園地で店長がゲーム大会をした','こぶた,たぬき,B,名無し',current_date,14);

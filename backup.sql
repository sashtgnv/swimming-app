--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-11-27 16:32:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16992)
-- Name: championship; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.championship (
    id integer NOT NULL,
    name text NOT NULL,
    date date NOT NULL,
    document_url text NOT NULL,
    adress text NOT NULL,
    photo_url text NOT NULL
);


ALTER TABLE public.championship OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 17157)
-- Name: championships_disciplines; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.championships_disciplines (
    id integer NOT NULL,
    id_champ integer,
    id_discipline integer
);


ALTER TABLE public.championships_disciplines OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 17156)
-- Name: championships_disciplines_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.championships_disciplines_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.championships_disciplines_id_seq OWNER TO postgres;

--
-- TOC entry 4955 (class 0 OID 0)
-- Dependencies: 234
-- Name: championships_disciplines_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.championships_disciplines_id_seq OWNED BY public.championships_disciplines.id;


--
-- TOC entry 215 (class 1259 OID 16991)
-- Name: championships_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.championships_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.championships_id_seq OWNER TO postgres;

--
-- TOC entry 4956 (class 0 OID 0)
-- Dependencies: 215
-- Name: championships_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.championships_id_seq OWNED BY public.championship.id;


--
-- TOC entry 226 (class 1259 OID 17052)
-- Name: discipline; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discipline (
    id integer NOT NULL,
    style text NOT NULL,
    distance integer NOT NULL
);


ALTER TABLE public.discipline OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17051)
-- Name: discipline_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.discipline_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.discipline_id_seq OWNER TO postgres;

--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 225
-- Name: discipline_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.discipline_id_seq OWNED BY public.discipline.id;


--
-- TOC entry 222 (class 1259 OID 17026)
-- Name: judge; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.judge (
    id integer NOT NULL,
    surname character varying(20) NOT NULL,
    name character varying(20) NOT NULL,
    patronymic character varying(20) NOT NULL,
    deserts text DEFAULT 'Не указано'::text NOT NULL
);


ALTER TABLE public.judge OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17025)
-- Name: judge_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.judge_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.judge_id_seq OWNER TO postgres;

--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 221
-- Name: judge_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.judge_id_seq OWNED BY public.judge.id;


--
-- TOC entry 224 (class 1259 OID 17035)
-- Name: judges_championships; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.judges_championships (
    id integer NOT NULL,
    id_judge integer NOT NULL,
    id_champ integer NOT NULL
);


ALTER TABLE public.judges_championships OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17034)
-- Name: judges_championships_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.judges_championships_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.judges_championships_id_seq OWNER TO postgres;

--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 223
-- Name: judges_championships_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.judges_championships_id_seq OWNED BY public.judges_championships.id;


--
-- TOC entry 232 (class 1259 OID 17102)
-- Name: organizer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.organizer (
    id integer NOT NULL,
    full_name text NOT NULL,
    login text NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.organizer OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 17101)
-- Name: organizer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.organizer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.organizer_id_seq OWNER TO postgres;

--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 231
-- Name: organizer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.organizer_id_seq OWNED BY public.organizer.id;


--
-- TOC entry 228 (class 1259 OID 17061)
-- Name: request; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.request (
    id integer NOT NULL,
    id_d integer NOT NULL,
    id_s integer NOT NULL,
    id_ch integer NOT NULL,
    request_time integer NOT NULL
);


ALTER TABLE public.request OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 17060)
-- Name: requests_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.requests_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.requests_id_seq OWNER TO postgres;

--
-- TOC entry 4961 (class 0 OID 0)
-- Dependencies: 227
-- Name: requests_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.requests_id_seq OWNED BY public.request.id;


--
-- TOC entry 230 (class 1259 OID 17090)
-- Name: result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.result (
    id integer NOT NULL,
    id_request integer NOT NULL,
    result_time integer
);


ALTER TABLE public.result OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 17089)
-- Name: result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.result_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.result_id_seq OWNER TO postgres;

--
-- TOC entry 4962 (class 0 OID 0)
-- Dependencies: 229
-- Name: result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.result_id_seq OWNED BY public.result.id;


--
-- TOC entry 233 (class 1259 OID 17132)
-- Name: sequence1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.sequence1 OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17011)
-- Name: sportsman; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sportsman (
    id integer NOT NULL,
    surname character varying(20) NOT NULL,
    name character varying(20) NOT NULL,
    patronymic character varying(20) NOT NULL,
    birth_date date NOT NULL,
    grade text DEFAULT 'Не указано'::text,
    id_trainer integer
);


ALTER TABLE public.sportsman OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 17010)
-- Name: sportsman_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sportsman_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.sportsman_id_seq OWNER TO postgres;

--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 219
-- Name: sportsman_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sportsman_id_seq OWNED BY public.sportsman.id;


--
-- TOC entry 218 (class 1259 OID 17001)
-- Name: trainer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trainer (
    id integer NOT NULL,
    surname character varying(20) NOT NULL,
    name character varying(20) NOT NULL,
    patronymic character varying(20) NOT NULL,
    birth_date date NOT NULL,
    grade text DEFAULT 'Не указано'::text
);


ALTER TABLE public.trainer OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 17000)
-- Name: trainer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trainer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.trainer_id_seq OWNER TO postgres;

--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 217
-- Name: trainer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trainer_id_seq OWNED BY public.trainer.id;


--
-- TOC entry 4734 (class 2604 OID 16995)
-- Name: championship id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.championship ALTER COLUMN id SET DEFAULT nextval('public.championships_id_seq'::regclass);


--
-- TOC entry 4746 (class 2604 OID 17160)
-- Name: championships_disciplines id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.championships_disciplines ALTER COLUMN id SET DEFAULT nextval('public.championships_disciplines_id_seq'::regclass);


--
-- TOC entry 4742 (class 2604 OID 17055)
-- Name: discipline id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline ALTER COLUMN id SET DEFAULT nextval('public.discipline_id_seq'::regclass);


--
-- TOC entry 4739 (class 2604 OID 17029)
-- Name: judge id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.judge ALTER COLUMN id SET DEFAULT nextval('public.judge_id_seq'::regclass);


--
-- TOC entry 4741 (class 2604 OID 17038)
-- Name: judges_championships id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.judges_championships ALTER COLUMN id SET DEFAULT nextval('public.judges_championships_id_seq'::regclass);


--
-- TOC entry 4745 (class 2604 OID 17105)
-- Name: organizer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organizer ALTER COLUMN id SET DEFAULT nextval('public.organizer_id_seq'::regclass);


--
-- TOC entry 4743 (class 2604 OID 17064)
-- Name: request id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request ALTER COLUMN id SET DEFAULT nextval('public.requests_id_seq'::regclass);


--
-- TOC entry 4744 (class 2604 OID 17093)
-- Name: result id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result ALTER COLUMN id SET DEFAULT nextval('public.result_id_seq'::regclass);


--
-- TOC entry 4737 (class 2604 OID 17014)
-- Name: sportsman id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sportsman ALTER COLUMN id SET DEFAULT nextval('public.sportsman_id_seq'::regclass);


--
-- TOC entry 4735 (class 2604 OID 17004)
-- Name: trainer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer ALTER COLUMN id SET DEFAULT nextval('public.trainer_id_seq'::regclass);


--
-- TOC entry 4930 (class 0 OID 16992)
-- Dependencies: 216
-- Data for Name: championship; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.championship (id, name, date, document_url, adress, photo_url) VALUES (1, 'Первенство', '2024-10-29', 'https://docs.google.com/document/d/1gYjE92l5FmtXlx98TWTj28tjtC8p9LeEpnnWqhGvn-E/edit?usp=drive_link', 'пр. Героев', 'https://swim-nn.ru/upload/iblock/d86/31xe709oodvbwtptghs3s4j90wts2ffs/Pervenstvo_Nizhegorodskoy_oblasti_po_plavaniyu.JPG');
INSERT INTO public.championship (id, name, date, document_url, adress, photo_url) VALUES (10, 'Чемпионат', '2024-10-10', 'https://docs.google.com/document/d/1gYjE92l5FmtXlx98TWTj28tjtC8p9LeEpnnWqhGvn-E/edit?usp=drive_link', 'пр. Гаганина', 'https://swim-nn.ru/upload/iblock/3a0/outu05w2wjah83xz0327u3ssi7fkgy75/Pervenstvo_Nizhegorodskoy_oblasti_po_plavaniyu.jpg');


--
-- TOC entry 4949 (class 0 OID 17157)
-- Dependencies: 235
-- Data for Name: championships_disciplines; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.championships_disciplines (id, id_champ, id_discipline) VALUES (1, 1, 1);
INSERT INTO public.championships_disciplines (id, id_champ, id_discipline) VALUES (4, 1, 2);
INSERT INTO public.championships_disciplines (id, id_champ, id_discipline) VALUES (5, 10, 1);
INSERT INTO public.championships_disciplines (id, id_champ, id_discipline) VALUES (6, 10, 2);


--
-- TOC entry 4940 (class 0 OID 17052)
-- Dependencies: 226
-- Data for Name: discipline; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.discipline (id, style, distance) VALUES (1, 'вольный стиль', 400);
INSERT INTO public.discipline (id, style, distance) VALUES (2, 'баттерфляй', 100);


--
-- TOC entry 4936 (class 0 OID 17026)
-- Dependencies: 222
-- Data for Name: judge; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.judge (id, surname, name, patronymic, deserts) VALUES (1, 'Веселова', 'Юлия', 'Сергеевна', 'Заслуженный судья федерации');
INSERT INTO public.judge (id, surname, name, patronymic, deserts) VALUES (2, 'Никифоров', 'Сергей', 'Владимирович', 'Судья федерации');


--
-- TOC entry 4938 (class 0 OID 17035)
-- Dependencies: 224
-- Data for Name: judges_championships; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.judges_championships (id, id_judge, id_champ) VALUES (3, 1, 1);
INSERT INTO public.judges_championships (id, id_judge, id_champ) VALUES (4, 2, 1);
INSERT INTO public.judges_championships (id, id_judge, id_champ) VALUES (5, 1, 10);
INSERT INTO public.judges_championships (id, id_judge, id_champ) VALUES (6, 2, 10);


--
-- TOC entry 4946 (class 0 OID 17102)
-- Dependencies: 232
-- Data for Name: organizer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.organizer (id, full_name, login, password) VALUES (1, 'Александр Андреевич Туганов', 'login', 'password');


--
-- TOC entry 4942 (class 0 OID 17061)
-- Dependencies: 228
-- Data for Name: request; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (5, 1, 2, 1, 253764);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (6, 1, 3, 1, 243873);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (7, 1, 4, 1, 253174);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (8, 1, 5, 1, 267429);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (9, 1, 6, 1, 266832);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (10, 1, 7, 1, 240827);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (11, 1, 8, 1, 257729);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (12, 1, 9, 1, 246170);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (13, 1, 10, 1, 247139);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (14, 1, 11, 1, 265404);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (15, 1, 12, 1, 262826);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (16, 1, 13, 1, 247788);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (17, 1, 14, 1, 249092);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (18, 1, 15, 1, 245942);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (19, 1, 16, 1, 241973);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (20, 1, 17, 1, 250814);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (21, 1, 18, 1, 267119);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (22, 1, 19, 1, 240385);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (23, 1, 20, 1, 240042);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (24, 1, 21, 1, 251843);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (25, 1, 22, 1, 256157);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (26, 1, 23, 1, 248115);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (27, 1, 24, 1, 250504);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (28, 1, 25, 1, 266180);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (29, 1, 26, 1, 263298);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (30, 1, 27, 1, 250270);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (31, 1, 28, 1, 262809);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (32, 1, 29, 1, 245360);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (33, 1, 30, 1, 243215);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (34, 1, 31, 1, 249542);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (35, 1, 32, 1, 250081);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (36, 1, 33, 1, 256417);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (37, 1, 34, 1, 243735);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (38, 1, 35, 1, 266109);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (39, 1, 36, 1, 246000);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (40, 1, 37, 1, 264647);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (41, 1, 38, 1, 241615);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (42, 1, 39, 1, 247005);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (43, 1, 40, 1, 243511);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (44, 1, 41, 1, 255123);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (45, 1, 42, 1, 257167);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (46, 1, 43, 1, 264354);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (47, 1, 44, 1, 263639);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (48, 1, 45, 1, 240514);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (49, 1, 46, 1, 252917);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (50, 1, 47, 1, 253410);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (51, 1, 48, 1, 264692);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (52, 1, 49, 1, 241092);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (53, 1, 50, 1, 264265);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (54, 1, 51, 1, 247017);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (55, 1, 52, 1, 245833);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (56, 1, 53, 1, 264904);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (57, 1, 54, 1, 246458);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (58, 1, 55, 1, 266453);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (59, 1, 56, 1, 263638);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (60, 1, 57, 1, 243942);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (61, 1, 58, 1, 240775);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (62, 1, 59, 1, 243979);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (63, 1, 60, 1, 243668);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (64, 1, 61, 1, 258920);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (65, 1, 62, 1, 264218);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (67, 1, 63, 1, 260776);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (68, 1, 64, 1, 247574);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (69, 1, 65, 1, 242703);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (70, 1, 66, 1, 267671);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (71, 1, 67, 1, 254198);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (72, 1, 68, 1, 245692);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (73, 1, 69, 1, 255443);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (74, 1, 70, 1, 250100);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (75, 1, 71, 1, 266957);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (76, 1, 72, 1, 261915);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (77, 1, 73, 1, 252168);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (78, 1, 74, 1, 256218);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (79, 1, 75, 1, 240448);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (80, 1, 76, 1, 263849);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (81, 1, 77, 1, 251460);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (82, 1, 78, 1, 252230);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (83, 1, 79, 1, 246645);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (84, 1, 80, 1, 261605);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (85, 1, 81, 1, 247224);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (86, 1, 82, 1, 261402);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (87, 1, 83, 1, 248150);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (88, 1, 84, 1, 244987);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (89, 1, 85, 1, 246542);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (90, 1, 86, 1, 255861);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (91, 1, 87, 1, 249509);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (92, 1, 88, 1, 265488);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (93, 1, 89, 1, 259884);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (94, 1, 90, 1, 261268);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (95, 1, 91, 1, 250381);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (96, 1, 92, 1, 243947);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (97, 1, 93, 1, 240438);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (98, 1, 94, 1, 262085);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (99, 1, 95, 1, 267827);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (100, 1, 96, 1, 267200);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (101, 1, 97, 1, 262192);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (102, 1, 98, 1, 255587);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (103, 1, 99, 1, 258284);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (104, 1, 100, 1, 240986);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (105, 1, 101, 1, 242560);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (106, 1, 102, 1, 245427);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (107, 1, 103, 1, 260039);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (108, 1, 104, 1, 264229);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (109, 1, 105, 1, 248018);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (110, 1, 106, 1, 267802);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (111, 1, 107, 1, 259915);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (112, 1, 108, 1, 261333);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (113, 1, 109, 1, 256789);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (114, 1, 110, 1, 243225);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (115, 1, 111, 1, 243163);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (116, 1, 112, 1, 254518);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (117, 1, 113, 1, 251043);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (118, 1, 114, 1, 246054);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (119, 1, 115, 1, 249206);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (120, 1, 116, 1, 250065);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (121, 1, 117, 1, 247198);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (122, 1, 118, 1, 254728);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (123, 1, 119, 1, 245244);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (124, 1, 120, 1, 264567);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (125, 1, 121, 1, 263925);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (126, 1, 122, 1, 258894);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (127, 1, 123, 1, 253641);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (128, 1, 124, 1, 262925);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (129, 1, 125, 1, 241382);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (130, 1, 126, 1, 267757);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (268, 2, 3, 1, 80010);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (269, 2, 2, 1, 79000);
INSERT INTO public.request (id, id_d, id_s, id_ch, request_time) VALUES (270, 1, 131, 10, 249088);


--
-- TOC entry 4944 (class 0 OID 17090)
-- Dependencies: 230
-- Data for Name: result; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.result (id, id_request, result_time) VALUES (2, 5, 263015);
INSERT INTO public.result (id, id_request, result_time) VALUES (3, 6, 254514);
INSERT INTO public.result (id, id_request, result_time) VALUES (4, 7, 266574);
INSERT INTO public.result (id, id_request, result_time) VALUES (5, 8, 266469);
INSERT INTO public.result (id, id_request, result_time) VALUES (6, 9, 265838);
INSERT INTO public.result (id, id_request, result_time) VALUES (7, 10, 241567);
INSERT INTO public.result (id, id_request, result_time) VALUES (8, 11, 261828);
INSERT INTO public.result (id, id_request, result_time) VALUES (9, 12, 234669);
INSERT INTO public.result (id, id_request, result_time) VALUES (10, 13, 260528);
INSERT INTO public.result (id, id_request, result_time) VALUES (11, 14, 233555);
INSERT INTO public.result (id, id_request, result_time) VALUES (12, 15, 242633);
INSERT INTO public.result (id, id_request, result_time) VALUES (13, 16, 234242);
INSERT INTO public.result (id, id_request, result_time) VALUES (14, 17, 244865);
INSERT INTO public.result (id, id_request, result_time) VALUES (15, 18, 240119);
INSERT INTO public.result (id, id_request, result_time) VALUES (16, 19, 258672);
INSERT INTO public.result (id, id_request, result_time) VALUES (17, 20, 237994);
INSERT INTO public.result (id, id_request, result_time) VALUES (18, 21, 254541);
INSERT INTO public.result (id, id_request, result_time) VALUES (19, 22, 243515);
INSERT INTO public.result (id, id_request, result_time) VALUES (20, 23, 234529);
INSERT INTO public.result (id, id_request, result_time) VALUES (21, 24, 236684);
INSERT INTO public.result (id, id_request, result_time) VALUES (22, 25, 245072);
INSERT INTO public.result (id, id_request, result_time) VALUES (23, 26, 233651);
INSERT INTO public.result (id, id_request, result_time) VALUES (24, 27, 239676);
INSERT INTO public.result (id, id_request, result_time) VALUES (25, 28, 240325);
INSERT INTO public.result (id, id_request, result_time) VALUES (26, 29, 239757);
INSERT INTO public.result (id, id_request, result_time) VALUES (27, 30, 243739);
INSERT INTO public.result (id, id_request, result_time) VALUES (28, 31, 264261);
INSERT INTO public.result (id, id_request, result_time) VALUES (29, 32, 256014);
INSERT INTO public.result (id, id_request, result_time) VALUES (30, 33, 258484);
INSERT INTO public.result (id, id_request, result_time) VALUES (31, 34, 250760);
INSERT INTO public.result (id, id_request, result_time) VALUES (32, 35, 252061);
INSERT INTO public.result (id, id_request, result_time) VALUES (33, 36, 253984);
INSERT INTO public.result (id, id_request, result_time) VALUES (34, 37, 250402);
INSERT INTO public.result (id, id_request, result_time) VALUES (35, 38, 266982);
INSERT INTO public.result (id, id_request, result_time) VALUES (36, 39, 243645);
INSERT INTO public.result (id, id_request, result_time) VALUES (37, 40, 266217);
INSERT INTO public.result (id, id_request, result_time) VALUES (38, 41, 240789);
INSERT INTO public.result (id, id_request, result_time) VALUES (39, 42, 263113);
INSERT INTO public.result (id, id_request, result_time) VALUES (40, 43, 252742);
INSERT INTO public.result (id, id_request, result_time) VALUES (41, 44, 266675);
INSERT INTO public.result (id, id_request, result_time) VALUES (42, 45, 246553);
INSERT INTO public.result (id, id_request, result_time) VALUES (43, 46, 244968);
INSERT INTO public.result (id, id_request, result_time) VALUES (44, 47, 237786);
INSERT INTO public.result (id, id_request, result_time) VALUES (45, 48, 255637);
INSERT INTO public.result (id, id_request, result_time) VALUES (46, 49, 245499);
INSERT INTO public.result (id, id_request, result_time) VALUES (47, 50, 234623);
INSERT INTO public.result (id, id_request, result_time) VALUES (48, 51, 243975);
INSERT INTO public.result (id, id_request, result_time) VALUES (49, 52, 253215);
INSERT INTO public.result (id, id_request, result_time) VALUES (50, 53, 242757);
INSERT INTO public.result (id, id_request, result_time) VALUES (51, 54, 254892);
INSERT INTO public.result (id, id_request, result_time) VALUES (52, 55, 234550);
INSERT INTO public.result (id, id_request, result_time) VALUES (53, 56, 236263);
INSERT INTO public.result (id, id_request, result_time) VALUES (54, 57, 241483);
INSERT INTO public.result (id, id_request, result_time) VALUES (55, 58, 249801);
INSERT INTO public.result (id, id_request, result_time) VALUES (56, 59, 258538);
INSERT INTO public.result (id, id_request, result_time) VALUES (57, 60, 260391);
INSERT INTO public.result (id, id_request, result_time) VALUES (58, 61, 252349);
INSERT INTO public.result (id, id_request, result_time) VALUES (59, 62, 242876);
INSERT INTO public.result (id, id_request, result_time) VALUES (60, 63, 247062);
INSERT INTO public.result (id, id_request, result_time) VALUES (61, 64, 231749);
INSERT INTO public.result (id, id_request, result_time) VALUES (62, 65, 257197);
INSERT INTO public.result (id, id_request, result_time) VALUES (64, 67, 251157);
INSERT INTO public.result (id, id_request, result_time) VALUES (65, 68, 255289);
INSERT INTO public.result (id, id_request, result_time) VALUES (67, 70, 256185);
INSERT INTO public.result (id, id_request, result_time) VALUES (68, 71, 254545);
INSERT INTO public.result (id, id_request, result_time) VALUES (69, 72, 259943);
INSERT INTO public.result (id, id_request, result_time) VALUES (70, 73, 245385);
INSERT INTO public.result (id, id_request, result_time) VALUES (71, 74, 262311);
INSERT INTO public.result (id, id_request, result_time) VALUES (72, 75, 254780);
INSERT INTO public.result (id, id_request, result_time) VALUES (73, 76, 260057);
INSERT INTO public.result (id, id_request, result_time) VALUES (74, 77, 257993);
INSERT INTO public.result (id, id_request, result_time) VALUES (75, 78, 230832);
INSERT INTO public.result (id, id_request, result_time) VALUES (76, 79, 238600);
INSERT INTO public.result (id, id_request, result_time) VALUES (77, 80, 251453);
INSERT INTO public.result (id, id_request, result_time) VALUES (78, 81, 230356);
INSERT INTO public.result (id, id_request, result_time) VALUES (79, 82, 237142);
INSERT INTO public.result (id, id_request, result_time) VALUES (80, 83, 239546);
INSERT INTO public.result (id, id_request, result_time) VALUES (81, 84, 232288);
INSERT INTO public.result (id, id_request, result_time) VALUES (82, 85, 232649);
INSERT INTO public.result (id, id_request, result_time) VALUES (83, 86, 255430);
INSERT INTO public.result (id, id_request, result_time) VALUES (84, 87, 252870);
INSERT INTO public.result (id, id_request, result_time) VALUES (85, 88, 248347);
INSERT INTO public.result (id, id_request, result_time) VALUES (86, 89, 255525);
INSERT INTO public.result (id, id_request, result_time) VALUES (87, 90, 256907);
INSERT INTO public.result (id, id_request, result_time) VALUES (88, 91, 249321);
INSERT INTO public.result (id, id_request, result_time) VALUES (89, 92, 260694);
INSERT INTO public.result (id, id_request, result_time) VALUES (90, 93, 265282);
INSERT INTO public.result (id, id_request, result_time) VALUES (91, 94, 234940);
INSERT INTO public.result (id, id_request, result_time) VALUES (92, 95, 236603);
INSERT INTO public.result (id, id_request, result_time) VALUES (93, 96, 256511);
INSERT INTO public.result (id, id_request, result_time) VALUES (94, 97, 254730);
INSERT INTO public.result (id, id_request, result_time) VALUES (95, 98, 252300);
INSERT INTO public.result (id, id_request, result_time) VALUES (96, 99, 252487);
INSERT INTO public.result (id, id_request, result_time) VALUES (97, 100, 262881);
INSERT INTO public.result (id, id_request, result_time) VALUES (98, 101, 236155);
INSERT INTO public.result (id, id_request, result_time) VALUES (99, 102, 250530);
INSERT INTO public.result (id, id_request, result_time) VALUES (100, 103, 266114);
INSERT INTO public.result (id, id_request, result_time) VALUES (101, 104, 252857);
INSERT INTO public.result (id, id_request, result_time) VALUES (102, 105, 233421);
INSERT INTO public.result (id, id_request, result_time) VALUES (103, 106, 247799);
INSERT INTO public.result (id, id_request, result_time) VALUES (104, 107, 241813);
INSERT INTO public.result (id, id_request, result_time) VALUES (105, 108, 261979);
INSERT INTO public.result (id, id_request, result_time) VALUES (106, 109, 245061);
INSERT INTO public.result (id, id_request, result_time) VALUES (107, 110, 259472);
INSERT INTO public.result (id, id_request, result_time) VALUES (108, 111, 261452);
INSERT INTO public.result (id, id_request, result_time) VALUES (109, 112, 230710);
INSERT INTO public.result (id, id_request, result_time) VALUES (110, 113, 246130);
INSERT INTO public.result (id, id_request, result_time) VALUES (111, 114, 267138);
INSERT INTO public.result (id, id_request, result_time) VALUES (112, 115, 244160);
INSERT INTO public.result (id, id_request, result_time) VALUES (113, 116, 233315);
INSERT INTO public.result (id, id_request, result_time) VALUES (114, 117, 258757);
INSERT INTO public.result (id, id_request, result_time) VALUES (115, 118, 254656);
INSERT INTO public.result (id, id_request, result_time) VALUES (116, 119, 235044);
INSERT INTO public.result (id, id_request, result_time) VALUES (117, 120, 265480);
INSERT INTO public.result (id, id_request, result_time) VALUES (118, 121, 265445);
INSERT INTO public.result (id, id_request, result_time) VALUES (119, 122, 265770);
INSERT INTO public.result (id, id_request, result_time) VALUES (120, 123, 233265);
INSERT INTO public.result (id, id_request, result_time) VALUES (121, 124, 247240);
INSERT INTO public.result (id, id_request, result_time) VALUES (122, 125, 232341);
INSERT INTO public.result (id, id_request, result_time) VALUES (123, 126, 262028);
INSERT INTO public.result (id, id_request, result_time) VALUES (124, 127, 243371);
INSERT INTO public.result (id, id_request, result_time) VALUES (125, 128, 231203);
INSERT INTO public.result (id, id_request, result_time) VALUES (126, 129, 260282);
INSERT INTO public.result (id, id_request, result_time) VALUES (127, 130, 246331);
INSERT INTO public.result (id, id_request, result_time) VALUES (130, 268, 80010);
INSERT INTO public.result (id, id_request, result_time) VALUES (131, 269, 79010);
INSERT INTO public.result (id, id_request, result_time) VALUES (132, 270, 682033);


--
-- TOC entry 4934 (class 0 OID 17011)
-- Dependencies: 220
-- Data for Name: sportsman; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (2, 'Александров', 'Александр', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (3, 'Сергеев', 'Александр', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (4, 'Дмитриев', 'Александр', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (5, 'Данилов', 'Александр', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (6, 'Антонов', 'Александр', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (7, 'Александров', 'Александр', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (8, 'Сергеев', 'Александр', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (9, 'Дмитриев', 'Александр', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (10, 'Данилов', 'Александр', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (11, 'Антонов', 'Александр', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (12, 'Александров', 'Александр', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (13, 'Сергеев', 'Александр', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (14, 'Дмитриев', 'Александр', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (15, 'Данилов', 'Александр', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (16, 'Антонов', 'Александр', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (17, 'Александров', 'Александр', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (18, 'Сергеев', 'Александр', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (19, 'Дмитриев', 'Александр', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (20, 'Данилов', 'Александр', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (21, 'Антонов', 'Александр', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (22, 'Александров', 'Александр', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (23, 'Сергеев', 'Александр', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (24, 'Дмитриев', 'Александр', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (25, 'Данилов', 'Александр', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (26, 'Антонов', 'Александр', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (27, 'Александров', 'Сергей', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (28, 'Сергеев', 'Сергей', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (29, 'Дмитриев', 'Сергей', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (30, 'Данилов', 'Сергей', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (31, 'Антонов', 'Сергей', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (32, 'Александров', 'Сергей', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (33, 'Сергеев', 'Сергей', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (34, 'Дмитриев', 'Сергей', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (35, 'Данилов', 'Сергей', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (36, 'Антонов', 'Сергей', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (37, 'Александров', 'Сергей', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (38, 'Сергеев', 'Сергей', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (39, 'Дмитриев', 'Сергей', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (40, 'Данилов', 'Сергей', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (41, 'Антонов', 'Сергей', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (42, 'Александров', 'Сергей', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (43, 'Сергеев', 'Сергей', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (44, 'Дмитриев', 'Сергей', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (45, 'Данилов', 'Сергей', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (46, 'Антонов', 'Сергей', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (47, 'Александров', 'Сергей', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (48, 'Сергеев', 'Сергей', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (49, 'Дмитриев', 'Сергей', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (50, 'Данилов', 'Сергей', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (51, 'Антонов', 'Сергей', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (52, 'Александров', 'Дмитрий', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (53, 'Сергеев', 'Дмитрий', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (54, 'Дмитриев', 'Дмитрий', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (55, 'Данилов', 'Дмитрий', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (56, 'Антонов', 'Дмитрий', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (57, 'Александров', 'Дмитрий', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (58, 'Сергеев', 'Дмитрий', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (59, 'Дмитриев', 'Дмитрий', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (60, 'Данилов', 'Дмитрий', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (61, 'Антонов', 'Дмитрий', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (62, 'Александров', 'Дмитрий', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (63, 'Сергеев', 'Дмитрий', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (64, 'Дмитриев', 'Дмитрий', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (65, 'Данилов', 'Дмитрий', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (66, 'Антонов', 'Дмитрий', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (67, 'Александров', 'Дмитрий', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (68, 'Сергеев', 'Дмитрий', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (69, 'Дмитриев', 'Дмитрий', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (70, 'Данилов', 'Дмитрий', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (71, 'Антонов', 'Дмитрий', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (72, 'Александров', 'Дмитрий', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (73, 'Сергеев', 'Дмитрий', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (74, 'Дмитриев', 'Дмитрий', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (75, 'Данилов', 'Дмитрий', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (76, 'Антонов', 'Дмитрий', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (77, 'Александров', 'Даниил', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (78, 'Сергеев', 'Даниил', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (79, 'Дмитриев', 'Даниил', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (80, 'Данилов', 'Даниил', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (81, 'Антонов', 'Даниил', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (82, 'Александров', 'Даниил', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (83, 'Сергеев', 'Даниил', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (84, 'Дмитриев', 'Даниил', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (85, 'Данилов', 'Даниил', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (86, 'Антонов', 'Даниил', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (87, 'Александров', 'Даниил', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (88, 'Сергеев', 'Даниил', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (89, 'Дмитриев', 'Даниил', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (90, 'Данилов', 'Даниил', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (91, 'Антонов', 'Даниил', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (92, 'Александров', 'Даниил', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (93, 'Сергеев', 'Даниил', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (94, 'Дмитриев', 'Даниил', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (95, 'Данилов', 'Даниил', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (96, 'Антонов', 'Даниил', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (97, 'Александров', 'Даниил', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (98, 'Сергеев', 'Даниил', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (99, 'Дмитриев', 'Даниил', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (100, 'Данилов', 'Даниил', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (101, 'Антонов', 'Даниил', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (102, 'Александров', 'Антон', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (103, 'Сергеев', 'Антон', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (104, 'Дмитриев', 'Антон', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (105, 'Данилов', 'Антон', 'Александрович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (106, 'Антонов', 'Антон', 'Александрович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (107, 'Александров', 'Антон', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (108, 'Сергеев', 'Антон', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (109, 'Дмитриев', 'Антон', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (110, 'Данилов', 'Антон', 'Сергеевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (111, 'Антонов', 'Антон', 'Сергеевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (112, 'Александров', 'Антон', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (113, 'Сергеев', 'Антон', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (114, 'Дмитриев', 'Антон', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (115, 'Данилов', 'Антон', 'Дмитриевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (116, 'Антонов', 'Антон', 'Дмитриевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (117, 'Александров', 'Антон', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (118, 'Сергеев', 'Антон', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (119, 'Дмитриев', 'Антон', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (120, 'Данилов', 'Антон', 'Андреевич', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (121, 'Антонов', 'Антон', 'Андреевич', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (122, 'Александров', 'Антон', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (123, 'Сергеев', 'Антон', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (124, 'Дмитриев', 'Антон', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (125, 'Данилов', 'Антон', 'Антонович', '2024-11-15', '1 взр.', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (126, 'Антонов', 'Антон', 'Антонович', '2024-11-15', 'КМС', 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (128, 'Туганов', 'Александр', 'Андреевич', '2006-02-20', NULL, 1);
INSERT INTO public.sportsman (id, surname, name, patronymic, birth_date, grade, id_trainer) VALUES (131, 'gghh', 'jjjj', 'hhhh', '4000-09-09', '3 юн.', NULL);


--
-- TOC entry 4932 (class 0 OID 17001)
-- Dependencies: 218
-- Data for Name: trainer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.trainer (id, surname, name, patronymic, birth_date, grade) VALUES (1, 'Веселова', 'Юлия', 'Сергеевна', '1983-03-06', 'КМС');
INSERT INTO public.trainer (id, surname, name, patronymic, birth_date, grade) VALUES (5, 'gghh', 'jjjj', 'hhhh', '4000-09-09', '3 взр.');


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 234
-- Name: championships_disciplines_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.championships_disciplines_id_seq', 6, true);


--
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 215
-- Name: championships_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.championships_id_seq', 10, true);


--
-- TOC entry 4967 (class 0 OID 0)
-- Dependencies: 225
-- Name: discipline_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.discipline_id_seq', 2, true);


--
-- TOC entry 4968 (class 0 OID 0)
-- Dependencies: 221
-- Name: judge_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.judge_id_seq', 2, true);


--
-- TOC entry 4969 (class 0 OID 0)
-- Dependencies: 223
-- Name: judges_championships_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.judges_championships_id_seq', 6, true);


--
-- TOC entry 4970 (class 0 OID 0)
-- Dependencies: 231
-- Name: organizer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.organizer_id_seq', 2, true);


--
-- TOC entry 4971 (class 0 OID 0)
-- Dependencies: 227
-- Name: requests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.requests_id_seq', 270, true);


--
-- TOC entry 4972 (class 0 OID 0)
-- Dependencies: 229
-- Name: result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.result_id_seq', 132, true);


--
-- TOC entry 4973 (class 0 OID 0)
-- Dependencies: 233
-- Name: sequence1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence1', 1, false);


--
-- TOC entry 4974 (class 0 OID 0)
-- Dependencies: 219
-- Name: sportsman_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sportsman_id_seq', 131, true);


--
-- TOC entry 4975 (class 0 OID 0)
-- Dependencies: 217
-- Name: trainer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trainer_id_seq', 5, true);


--
-- TOC entry 4776 (class 2606 OID 17162)
-- Name: championships_disciplines championships_disciplines_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.championships_disciplines
    ADD CONSTRAINT championships_disciplines_pkey PRIMARY KEY (id);


--
-- TOC entry 4748 (class 2606 OID 16999)
-- Name: championship championships_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.championship
    ADD CONSTRAINT championships_pkey PRIMARY KEY (id);


--
-- TOC entry 4762 (class 2606 OID 17059)
-- Name: discipline discipline_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discipline
    ADD CONSTRAINT discipline_pkey PRIMARY KEY (id);


--
-- TOC entry 4758 (class 2606 OID 17033)
-- Name: judge judge_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.judge
    ADD CONSTRAINT judge_pkey PRIMARY KEY (id);


--
-- TOC entry 4760 (class 2606 OID 17040)
-- Name: judges_championships judges_championships_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.judges_championships
    ADD CONSTRAINT judges_championships_pkey PRIMARY KEY (id);


--
-- TOC entry 4772 (class 2606 OID 17111)
-- Name: organizer organizer_login_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organizer
    ADD CONSTRAINT organizer_login_key UNIQUE (login);


--
-- TOC entry 4774 (class 2606 OID 17109)
-- Name: organizer organizer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organizer
    ADD CONSTRAINT organizer_pkey PRIMARY KEY (id);


--
-- TOC entry 4764 (class 2606 OID 17066)
-- Name: request requests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT requests_pkey PRIMARY KEY (id);


--
-- TOC entry 4768 (class 2606 OID 17095)
-- Name: result result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result
    ADD CONSTRAINT result_pkey PRIMARY KEY (id);


--
-- TOC entry 4754 (class 2606 OID 17019)
-- Name: sportsman sportsman_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sportsman
    ADD CONSTRAINT sportsman_pkey PRIMARY KEY (id);


--
-- TOC entry 4756 (class 2606 OID 25422)
-- Name: sportsman sportsman_unique_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sportsman
    ADD CONSTRAINT sportsman_unique_key UNIQUE (surname, name, patronymic, birth_date);


--
-- TOC entry 4750 (class 2606 OID 17009)
-- Name: trainer trainer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer
    ADD CONSTRAINT trainer_pkey PRIMARY KEY (id);


--
-- TOC entry 4752 (class 2606 OID 25431)
-- Name: trainer trainer_unique_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer
    ADD CONSTRAINT trainer_unique_key UNIQUE (surname, name, patronymic, birth_date);


--
-- TOC entry 4766 (class 2606 OID 25448)
-- Name: request unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT "unique" UNIQUE (id_d, id_s, id_ch);


--
-- TOC entry 4770 (class 2606 OID 25450)
-- Name: result unique_1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result
    ADD CONSTRAINT unique_1 UNIQUE (id_request, result_time);


--
-- TOC entry 4784 (class 2606 OID 17163)
-- Name: championships_disciplines championships_disciplines_id_champ_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.championships_disciplines
    ADD CONSTRAINT championships_disciplines_id_champ_fkey FOREIGN KEY (id_champ) REFERENCES public.championship(id);


--
-- TOC entry 4785 (class 2606 OID 17168)
-- Name: championships_disciplines championships_disciplines_id_discipline_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.championships_disciplines
    ADD CONSTRAINT championships_disciplines_id_discipline_fkey FOREIGN KEY (id_discipline) REFERENCES public.discipline(id);


--
-- TOC entry 4778 (class 2606 OID 17046)
-- Name: judges_championships judges_championships_id_champ_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.judges_championships
    ADD CONSTRAINT judges_championships_id_champ_fkey FOREIGN KEY (id_champ) REFERENCES public.championship(id);


--
-- TOC entry 4779 (class 2606 OID 17041)
-- Name: judges_championships judges_championships_id_judge_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.judges_championships
    ADD CONSTRAINT judges_championships_id_judge_fkey FOREIGN KEY (id_judge) REFERENCES public.judge(id);


--
-- TOC entry 4780 (class 2606 OID 17077)
-- Name: request requests_id_ch_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT requests_id_ch_fkey FOREIGN KEY (id_ch) REFERENCES public.championship(id);


--
-- TOC entry 4781 (class 2606 OID 17067)
-- Name: request requests_id_d_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT requests_id_d_fkey FOREIGN KEY (id_d) REFERENCES public.discipline(id);


--
-- TOC entry 4782 (class 2606 OID 17072)
-- Name: request requests_id_s_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT requests_id_s_fkey FOREIGN KEY (id_s) REFERENCES public.sportsman(id);


--
-- TOC entry 4783 (class 2606 OID 17096)
-- Name: result result_id_request_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result
    ADD CONSTRAINT result_id_request_fkey FOREIGN KEY (id_request) REFERENCES public.request(id);


--
-- TOC entry 4777 (class 2606 OID 17020)
-- Name: sportsman sportsman_id_trainer_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sportsman
    ADD CONSTRAINT sportsman_id_trainer_fkey FOREIGN KEY (id_trainer) REFERENCES public.trainer(id);


-- Completed on 2024-11-27 16:32:18

--
-- PostgreSQL database dump complete
--


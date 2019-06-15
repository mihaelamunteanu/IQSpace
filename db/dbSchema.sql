--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2019-06-15 16:28:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 32810)
-- Name: questions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.questions (
    id bigint NOT NULL,
    test_id bigint NOT NULL,
    question_type character varying NOT NULL,
    question character varying(1000) NOT NULL,
    hint1 character varying(300),
    hint2 character varying(300),
    other_observations character varying(500),
    question_number bigint NOT NULL,
    answer character varying NOT NULL,
    answer_explanations character varying(1000),
    wrong_answer1 character varying,
    wrong_answer2 character varying,
    image1 character varying DEFAULT 'Default.png'::character varying
);


ALTER TABLE public.questions OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32808)
-- Name: questions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.questions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.questions_id_seq OWNER TO postgres;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 202
-- Name: questions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.questions_id_seq OWNED BY public.questions.id;


--
-- TOC entry 199 (class 1259 OID 32781)
-- Name: tests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tests (
    id bigint NOT NULL,
    test_name character varying NOT NULL,
    observations character varying,
    creation_date date NOT NULL,
    test_type character varying NOT NULL,
    number_of_questions bigint DEFAULT 20,
    modification_date date DEFAULT now() NOT NULL
);


ALTER TABLE public.tests OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 32779)
-- Name: test_results_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.test_results_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_results_id_seq OWNER TO postgres;

--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 198
-- Name: test_results_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.test_results_id_seq OWNED BY public.tests.id;


--
-- TOC entry 201 (class 1259 OID 32792)
-- Name: visitor_test_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.visitor_test_result (
    id bigint NOT NULL,
    test_date date NOT NULL,
    test_result bigint NOT NULL,
    test_observation character varying(300),
    used_mail character varying(100),
    visitor_id bigint NOT NULL,
    test_id bigint NOT NULL
);


ALTER TABLE public.visitor_test_result OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 32790)
-- Name: visitor_test_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.visitor_test_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.visitor_test_result_id_seq OWNER TO postgres;

--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 200
-- Name: visitor_test_result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.visitor_test_result_id_seq OWNED BY public.visitor_test_result.id;


--
-- TOC entry 197 (class 1259 OID 32773)
-- Name: visitors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.visitors (
    id bigint NOT NULL,
    mail character varying(60),
    subscription_date date NOT NULL,
    first_name character varying(60),
    last_name character varying(60),
    other_info character varying(200),
    telephone_number character varying(20)
);


ALTER TABLE public.visitors OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 32771)
-- Name: vizitors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vizitors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vizitors_id_seq OWNER TO postgres;

--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 196
-- Name: vizitors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vizitors_id_seq OWNED BY public.visitors.id;


--
-- TOC entry 205 (class 1259 OID 32827)
-- Name: wrong_answers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wrong_answers (
    id bigint NOT NULL,
    question_id bigint NOT NULL,
    wrong_answer character varying(500) NOT NULL,
    other_observations character varying(300)
);


ALTER TABLE public.wrong_answers OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32825)
-- Name: wrong_answers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.wrong_answers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.wrong_answers_id_seq OWNER TO postgres;

--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 204
-- Name: wrong_answers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.wrong_answers_id_seq OWNED BY public.wrong_answers.id;


--
-- TOC entry 2717 (class 2604 OID 32813)
-- Name: questions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions ALTER COLUMN id SET DEFAULT nextval('public.questions_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 32784)
-- Name: tests id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tests ALTER COLUMN id SET DEFAULT nextval('public.test_results_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 32795)
-- Name: visitor_test_result id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.visitor_test_result ALTER COLUMN id SET DEFAULT nextval('public.visitor_test_result_id_seq'::regclass);


--
-- TOC entry 2712 (class 2604 OID 32776)
-- Name: visitors id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.visitors ALTER COLUMN id SET DEFAULT nextval('public.vizitors_id_seq'::regclass);


--
-- TOC entry 2719 (class 2604 OID 32830)
-- Name: wrong_answers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wrong_answers ALTER COLUMN id SET DEFAULT nextval('public.wrong_answers_id_seq'::regclass);


--
-- TOC entry 2727 (class 2606 OID 32818)
-- Name: questions questions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 32789)
-- Name: tests test_results_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tests
    ADD CONSTRAINT test_results_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 32797)
-- Name: visitor_test_result visitor_test_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.visitor_test_result
    ADD CONSTRAINT visitor_test_result_pkey PRIMARY KEY (id);


--
-- TOC entry 2721 (class 2606 OID 32778)
-- Name: visitors vizitors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.visitors
    ADD CONSTRAINT vizitors_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 32835)
-- Name: wrong_answers wrong_answers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wrong_answers
    ADD CONSTRAINT wrong_answers_pkey PRIMARY KEY (id);


--
-- TOC entry 2732 (class 2606 OID 32819)
-- Name: questions test_question_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT test_question_fk FOREIGN KEY (test_id) REFERENCES public.tests(id);


--
-- TOC entry 2731 (class 2606 OID 32803)
-- Name: visitor_test_result test_results_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.visitor_test_result
    ADD CONSTRAINT test_results_fk FOREIGN KEY (test_id) REFERENCES public.tests(id);


--
-- TOC entry 2730 (class 2606 OID 32798)
-- Name: visitor_test_result visitor_test_result_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.visitor_test_result
    ADD CONSTRAINT visitor_test_result_fk FOREIGN KEY (visitor_id) REFERENCES public.visitors(id);


--
-- TOC entry 2733 (class 2606 OID 32836)
-- Name: wrong_answers wrong_aswers_for_question_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wrong_answers
    ADD CONSTRAINT wrong_aswers_for_question_fk FOREIGN KEY (question_id) REFERENCES public.questions(id);


-- Completed on 2019-06-15 16:28:20

--
-- PostgreSQL database dump complete
--


package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "baremo")
public class BaremoDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long baremoId;

    private String localidad;
    private String edad;
    private String genero;
    private String nivelDeEstudio;
    private String ocupacion;

    private Integer basica_l;
    private Integer basica_f;
    private Integer basica_k;
    private Integer basica_hs;
    private Integer basica_d;
    private Integer basica_hy;
    private Integer basica_pd;
    private Integer basica_mf_m;
    private Integer basica_mf_f;
    private Integer basica_pa;
    private Integer basica_pt;
    private Integer basica_sc;
    private Integer basica_ma;
    private Integer basica_si;

    private Integer contenido_anx;
    private Integer contenido_frs;
    private Integer contenido_obs;
    private Integer contenido_dep;
    private Integer contenido_hea;
    private Integer contenido_biz;
    private Integer contenido_ang;
    private Integer contenido_cyn;
    private Integer contenido_asp;
    private Integer contenido_tpa;
    private Integer contenido_lse;
    private Integer contenido_sod;
    private Integer contenido_fam;
    private Integer contenido_wrk;
    private Integer contenido_trt;

    private Integer suplementarias_a;
    private Integer suplementarias_r;
    private Integer suplementarias_es;
    private Integer suplementarias_mac_r;
    private Integer suplementarias_o_h;
    private Integer suplementarias_do;
    private Integer suplementarias_re;
    private Integer suplementarias_mt;
    private Integer suplementarias_gm;
    private Integer suplementarias_gf;
    private Integer suplementarias_pk;
    private Integer suplementarias_ps;
    private Integer suplementarias_si1;
    private Integer suplementarias_si2;
    private Integer suplementarias_si3;
    private Integer suplementarias_mds;
    private Integer suplementarias_aps;
    private Integer suplementarias_aas;

    private Integer fb_back;
    private Integer f_p;
    private Integer ds;
    private Integer ds_r;
    private Integer s;
    private Integer sd;
    private Integer so;
    private Integer vrin;
    private Integer trin;


    public BaremoDAO() {
    }
    public BaremoDAO(Long baremoId, String localidad, String edad, String genero, String nivelDeEstudio, String ocupacion, Integer basica_l, Integer basica_f, Integer basica_k, Integer basica_hs, Integer basica_d, Integer basica_hy, Integer basica_pd, Integer basica_mf_m, Integer basica_mf_f, Integer basica_pa, Integer basica_pt, Integer basica_sc, Integer basica_ma, Integer basica_si, Integer contenido_anx, Integer contenido_frs, Integer contenido_obs, Integer contenido_dep, Integer contenido_hea, Integer contenido_biz, Integer contenido_ang, Integer contenido_cyn, Integer contenido_asp, Integer contenido_tpa, Integer contenido_lse, Integer contenido_sod, Integer contenido_fam, Integer contenido_wrk, Integer contenido_trt, Integer suplementarias_a, Integer suplementarias_r, Integer suplementarias_es, Integer suplementarias_mac_r, Integer suplementarias_o_h, Integer suplementarias_do, Integer suplementarias_re, Integer suplementarias_mt, Integer suplementarias_gm, Integer suplementarias_gf, Integer suplementarias_pk, Integer suplementarias_ps, Integer suplementarias_si1, Integer suplementarias_si2, Integer suplementarias_si3, Integer suplementarias_mds, Integer suplementarias_aps, Integer suplementarias_aas, Integer fb_back, Integer f_p, Integer ds, Integer ds_r, Integer s, Integer sd, Integer so, Integer vrin, Integer trin) {
        this.baremoId = baremoId;
        this.localidad = localidad;
        this.edad = edad;
        this.genero = genero;
        this.nivelDeEstudio = nivelDeEstudio;
        this.ocupacion = ocupacion;
        this.basica_l = basica_l;
        this.basica_f = basica_f;
        this.basica_k = basica_k;
        this.basica_hs = basica_hs;
        this.basica_d = basica_d;
        this.basica_hy = basica_hy;
        this.basica_pd = basica_pd;
        this.basica_mf_m = basica_mf_m;
        this.basica_mf_f = basica_mf_f;
        this.basica_pa = basica_pa;
        this.basica_pt = basica_pt;
        this.basica_sc = basica_sc;
        this.basica_ma = basica_ma;
        this.basica_si = basica_si;
        this.contenido_anx = contenido_anx;
        this.contenido_frs = contenido_frs;
        this.contenido_obs = contenido_obs;
        this.contenido_dep = contenido_dep;
        this.contenido_hea = contenido_hea;
        this.contenido_biz = contenido_biz;
        this.contenido_ang = contenido_ang;
        this.contenido_cyn = contenido_cyn;
        this.contenido_asp = contenido_asp;
        this.contenido_tpa = contenido_tpa;
        this.contenido_lse = contenido_lse;
        this.contenido_sod = contenido_sod;
        this.contenido_fam = contenido_fam;
        this.contenido_wrk = contenido_wrk;
        this.contenido_trt = contenido_trt;
        this.suplementarias_a = suplementarias_a;
        this.suplementarias_r = suplementarias_r;
        this.suplementarias_es = suplementarias_es;
        this.suplementarias_mac_r = suplementarias_mac_r;
        this.suplementarias_o_h = suplementarias_o_h;
        this.suplementarias_do = suplementarias_do;
        this.suplementarias_re = suplementarias_re;
        this.suplementarias_mt = suplementarias_mt;
        this.suplementarias_gm = suplementarias_gm;
        this.suplementarias_gf = suplementarias_gf;
        this.suplementarias_pk = suplementarias_pk;
        this.suplementarias_ps = suplementarias_ps;
        this.suplementarias_si1 = suplementarias_si1;
        this.suplementarias_si2 = suplementarias_si2;
        this.suplementarias_si3 = suplementarias_si3;
        this.suplementarias_mds = suplementarias_mds;
        this.suplementarias_aps = suplementarias_aps;
        this.suplementarias_aas = suplementarias_aas;
        this.fb_back = fb_back;
        this.f_p = f_p;
        this.ds = ds;
        this.ds_r = ds_r;
        this.s = s;
        this.sd = sd;
        this.so = so;
        this.vrin = vrin;
        this.trin = trin;
    }


    public Long getBaremoId() {
        return baremoId;
    }
    public void setBaremoId(Long baremoId) {
        this.baremoId = baremoId;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getNivelDeEstudio() {
        return nivelDeEstudio;
    }
    public void setNivelDeEstudio(String nivelDeEstudio) {
        this.nivelDeEstudio = nivelDeEstudio;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public Integer getBasica_l() {
        return basica_l;
    }
    public void setBasica_l(Integer basica_l) {
        this.basica_l = basica_l;
    }
    public Integer getBasica_f() {
        return basica_f;
    }
    public void setBasica_f(Integer basica_f) {
        this.basica_f = basica_f;
    }
    public Integer getBasica_k() {
        return basica_k;
    }
    public void setBasica_k(Integer basica_k) {
        this.basica_k = basica_k;
    }
    public Integer getBasica_hs() {
        return basica_hs;
    }
    public void setBasica_hs(Integer basica_hs) {
        this.basica_hs = basica_hs;
    }
    public Integer getBasica_d() {
        return basica_d;
    }
    public void setBasica_d(Integer basica_d) {
        this.basica_d = basica_d;
    }
    public Integer getBasica_hy() {
        return basica_hy;
    }
    public void setBasica_hy(Integer basica_hy) {
        this.basica_hy = basica_hy;
    }
    public Integer getBasica_pd() {
        return basica_pd;
    }
    public void setBasica_pd(Integer basica_pd) {
        this.basica_pd = basica_pd;
    }
    public Integer getBasica_mf_m() {
        return basica_mf_m;
    }
    public void setBasica_mf_m(Integer basica_mf_m) {
        this.basica_mf_m = basica_mf_m;
    }
    public Integer getBasica_mf_f() {
        return basica_mf_f;
    }
    public void setBasica_mf_f(Integer basica_mf_f) {
        this.basica_mf_f = basica_mf_f;
    }
    public Integer getBasica_pa() {
        return basica_pa;
    }
    public void setBasica_pa(Integer basica_pa) {
        this.basica_pa = basica_pa;
    }
    public Integer getBasica_pt() {
        return basica_pt;
    }
    public void setBasica_pt(Integer basica_pt) {
        this.basica_pt = basica_pt;
    }
    public Integer getBasica_sc() {
        return basica_sc;
    }
    public void setBasica_sc(Integer basica_sc) {
        this.basica_sc = basica_sc;
    }
    public Integer getBasica_ma() {
        return basica_ma;
    }
    public void setBasica_ma(Integer basica_ma) {
        this.basica_ma = basica_ma;
    }
    public Integer getBasica_si() {
        return basica_si;
    }
    public void setBasica_si(Integer basica_si) {
        this.basica_si = basica_si;
    }
    public Integer getContenido_anx() {
        return contenido_anx;
    }
    public void setContenido_anx(Integer contenido_anx) {
        this.contenido_anx = contenido_anx;
    }
    public Integer getContenido_frs() {
        return contenido_frs;
    }
    public void setContenido_frs(Integer contenido_frs) {
        this.contenido_frs = contenido_frs;
    }
    public Integer getContenido_obs() {
        return contenido_obs;
    }
    public void setContenido_obs(Integer contenido_obs) {
        this.contenido_obs = contenido_obs;
    }
    public Integer getContenido_dep() {
        return contenido_dep;
    }
    public void setContenido_dep(Integer contenido_dep) {
        this.contenido_dep = contenido_dep;
    }
    public Integer getContenido_hea() {
        return contenido_hea;
    }
    public void setContenido_hea(Integer contenido_hea) {
        this.contenido_hea = contenido_hea;
    }
    public Integer getContenido_biz() {
        return contenido_biz;
    }
    public void setContenido_biz(Integer contenido_biz) {
        this.contenido_biz = contenido_biz;
    }
    public Integer getContenido_ang() {
        return contenido_ang;
    }
    public void setContenido_ang(Integer contenido_ang) {
        this.contenido_ang = contenido_ang;
    }
    public Integer getContenido_cyn() {
        return contenido_cyn;
    }
    public void setContenido_cyn(Integer contenido_cyn) {
        this.contenido_cyn = contenido_cyn;
    }
    public Integer getContenido_asp() {
        return contenido_asp;
    }
    public void setContenido_asp(Integer contenido_asp) {
        this.contenido_asp = contenido_asp;
    }
    public Integer getContenido_tpa() {
        return contenido_tpa;
    }
    public void setContenido_tpa(Integer contenido_tpa) {
        this.contenido_tpa = contenido_tpa;
    }
    public Integer getContenido_lse() {
        return contenido_lse;
    }
    public void setContenido_lse(Integer contenido_lse) {
        this.contenido_lse = contenido_lse;
    }
    public Integer getContenido_sod() {
        return contenido_sod;
    }
    public void setContenido_sod(Integer contenido_sod) {
        this.contenido_sod = contenido_sod;
    }
    public Integer getContenido_fam() {
        return contenido_fam;
    }
    public void setContenido_fam(Integer contenido_fam) {
        this.contenido_fam = contenido_fam;
    }
    public Integer getContenido_wrk() {
        return contenido_wrk;
    }
    public void setContenido_wrk(Integer contenido_wrk) {
        this.contenido_wrk = contenido_wrk;
    }
    public Integer getContenido_trt() {
        return contenido_trt;
    }
    public void setContenido_trt(Integer contenido_trt) {
        this.contenido_trt = contenido_trt;
    }
    public Integer getSuplementarias_a() {
        return suplementarias_a;
    }
    public void setSuplementarias_a(Integer suplementarias_a) {
        this.suplementarias_a = suplementarias_a;
    }
    public Integer getSuplementarias_r() {
        return suplementarias_r;
    }
    public void setSuplementarias_r(Integer suplementarias_r) {
        this.suplementarias_r = suplementarias_r;
    }
    public Integer getSuplementarias_es() {
        return suplementarias_es;
    }
    public void setSuplementarias_es(Integer suplementarias_es) {
        this.suplementarias_es = suplementarias_es;
    }
    public Integer getSuplementarias_mac_r() {
        return suplementarias_mac_r;
    }
    public void setSuplementarias_mac_r(Integer suplementarias_mac_r) {
        this.suplementarias_mac_r = suplementarias_mac_r;
    }
    public Integer getSuplementarias_o_h() {
        return suplementarias_o_h;
    }
    public void setSuplementarias_o_h(Integer suplementarias_o_h) {
        this.suplementarias_o_h = suplementarias_o_h;
    }
    public Integer getSuplementarias_do() {
        return suplementarias_do;
    }
    public void setSuplementarias_do(Integer suplementarias_do) {
        this.suplementarias_do = suplementarias_do;
    }
    public Integer getSuplementarias_re() {
        return suplementarias_re;
    }
    public void setSuplementarias_re(Integer suplementarias_re) {
        this.suplementarias_re = suplementarias_re;
    }
    public Integer getSuplementarias_mt() {
        return suplementarias_mt;
    }
    public void setSuplementarias_mt(Integer suplementarias_mt) {
        this.suplementarias_mt = suplementarias_mt;
    }
    public Integer getSuplementarias_gm() {
        return suplementarias_gm;
    }
    public void setSuplementarias_gm(Integer suplementarias_gm) {
        this.suplementarias_gm = suplementarias_gm;
    }
    public Integer getSuplementarias_gf() {
        return suplementarias_gf;
    }
    public void setSuplementarias_gf(Integer suplementarias_gf) {
        this.suplementarias_gf = suplementarias_gf;
    }
    public Integer getSuplementarias_pk() {
        return suplementarias_pk;
    }
    public void setSuplementarias_pk(Integer suplementarias_pk) {
        this.suplementarias_pk = suplementarias_pk;
    }
    public Integer getSuplementarias_ps() {
        return suplementarias_ps;
    }
    public void setSuplementarias_ps(Integer suplementarias_ps) {
        this.suplementarias_ps = suplementarias_ps;
    }
    public Integer getSuplementarias_si1() {
        return suplementarias_si1;
    }
    public void setSuplementarias_si1(Integer suplementarias_si1) {
        this.suplementarias_si1 = suplementarias_si1;
    }
    public Integer getSuplementarias_si2() {
        return suplementarias_si2;
    }
    public void setSuplementarias_si2(Integer suplementarias_si2) {
        this.suplementarias_si2 = suplementarias_si2;
    }
    public Integer getSuplementarias_si3() {
        return suplementarias_si3;
    }
    public void setSuplementarias_si3(Integer suplementarias_si3) {
        this.suplementarias_si3 = suplementarias_si3;
    }
    public Integer getSuplementarias_mds() {
        return suplementarias_mds;
    }
    public void setSuplementarias_mds(Integer suplementarias_mds) {
        this.suplementarias_mds = suplementarias_mds;
    }
    public Integer getSuplementarias_aps() {
        return suplementarias_aps;
    }
    public void setSuplementarias_aps(Integer suplementarias_aps) {
        this.suplementarias_aps = suplementarias_aps;
    }
    public Integer getSuplementarias_aas() {
        return suplementarias_aas;
    }
    public void setSuplementarias_aas(Integer suplementarias_aas) {
        this.suplementarias_aas = suplementarias_aas;
    }
    public Integer getFb_back() {
        return fb_back;
    }
    public void setFb_back(Integer fb_back) {
        this.fb_back = fb_back;
    }
    public Integer getF_p() {
        return f_p;
    }
    public void setF_p(Integer f_p) {
        this.f_p = f_p;
    }
    public Integer getDs() {
        return ds;
    }
    public void setDs(Integer ds) {
        this.ds = ds;
    }
    public Integer getDs_r() {
        return ds_r;
    }
    public void setDs_r(Integer ds_r) {
        this.ds_r = ds_r;
    }
    public Integer getS() {
        return s;
    }
    public void setS(Integer s) {
        this.s = s;
    }
    public Integer getSd() {
        return sd;
    }
    public void setSd(Integer sd) {
        this.sd = sd;
    }
    public Integer getSo() {
        return so;
    }
    public void setSo(Integer so) {
        this.so = so;
    }
    public Integer getVrin() {
        return vrin;
    }
    public void setVrin(Integer vrin) {
        this.vrin = vrin;
    }
    public Integer getTrin() {
        return trin;
    }
    public void setTrin(Integer trin) {
        this.trin = trin;
    }

}

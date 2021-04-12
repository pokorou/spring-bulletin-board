package com.example.dataBaseSample.Application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")

public class IndexController {
	
	@ModelAttribute("name")
	
	String name() {
		return "名無し";
	}

	@Autowired
	ThreadDataEntityRepository threadDataRepository;
	@Autowired
	ThreadDataEntityRepositoryCustom threadDataRepositoryCustom;
	@Autowired
	ComentDataEntityRepository comentDataRepository;
	@Autowired
	ComentDataRepositoryCustom comentDataRepositoryCustom;

	//初期画面
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@ResponseBody
	public String index(Model model) {
		List<ThreadDataEntity> data = threadDataRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("threadData", data);
		model.addAttribute("startFlag", false);
		return "index";
	}

	//スレッド作成をおしたとき
	@RequestMapping(value = "/newThread", method = RequestMethod.POST)
	//@ResponseBody
	public String onClickNewThread(@RequestParam("title") String title, @ModelAttribute("name") String name,
			@RequestParam("message") String message, Model model) {
		ThreadDataEntity td = new ThreadDataEntity(title, name, message);
		threadDataRepository.save(td);
		threadDataRepository.flush();
		comentDataRepository.save(new ComentDataEntity(td.getId(), name, message));
		comentDataRepository.flush();
		List<ThreadDataEntity> data = threadDataRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("threadData", data);
		return "index";
	}

	//詳細閲覧を押したときの処理
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String onClickView(@RequestParam String threadNumber, Model model) {
		//スレッド番号を取得しコメントDBからスレッド版番号が一致するものを取り出し、モデルに格納
		Integer num = Integer.parseInt(threadNumber);
		List<ComentDataEntity> data = comentDataRepositoryCustom.searchThread(num);
		model.addAttribute("ComentData", data);
		return "view";
	}

	//書き込みボタンが押されたとき
	@RequestMapping(value = "/newComent", method = RequestMethod.POST)
	public String onClickNewComent(@RequestParam String threadNumber, @ModelAttribute("name") String name,
			@RequestParam String message, Model model) {
		comentDataRepository.save(new ComentDataEntity(Integer.parseInt(threadNumber), name, message));
		comentDataRepository.flush();
		Integer num = Integer.parseInt(threadNumber);
		List<ComentDataEntity> data = comentDataRepositoryCustom.searchThread(num);
		model.addAttribute("ComentData", data);
		return "view";
	}
	//index.htmlで名前変更を押したとき
	@RequestMapping(value = "/tlansitonNameChange", method = RequestMethod.GET)
	//@ResponseBody
	public String onClickTlansitionNameChange(Model model) {
		return "nameChange";
	}
//view.htmlで変更を押したとき
	@RequestMapping(value = "/nameChange", method = RequestMethod.POST)
	//@ResponseBody
	public String onClicknameChange(@RequestParam String newName,Model model) {
		model.addAttribute("name",newName);
		List<ThreadDataEntity> data = threadDataRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("threadData", data);
		return "index";
	}
	//検索ボタンが押されたとき
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	//@ResponseBody
	public String onClickSearch(@RequestParam String search,Model model) {
		List<ThreadDataEntity> data =  threadDataRepositoryCustom.search(search);
		model.addAttribute("threadData", data);
		model.addAttribute("startFlag",true);
		return "index";
	}
}
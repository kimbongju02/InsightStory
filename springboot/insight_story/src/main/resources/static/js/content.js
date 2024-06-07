const chat_div = document.querySelector('.chat');
const options = document.querySelector('.options');
const history = document.querySelector('.history');

var part_cnt = 0;
const data_history = {};
const choice_history = {};

window.onload = function() {

    laod_start_story();

    var historyContainer = document.querySelector('.history');
    historyContainer.scrollTop = historyContainer.scrollHeight;
};

function laod_start_story(){
    // fetch('/api/story')
    fetch('/api/story')
    .then(response => response.json())
    .then(data => {
        create_chat_div(data);
    })
    .catch(error => console.error('Error:', error));
}

async function create_chat_div(data) {
    const part = document.createElement('div');
    part.id = 'part-' + part_cnt;
    part.setAttribute('data-value', part_cnt);
    chat_div.appendChild(part);
    await add_story(part, data['story']);
    await add_dialogue(part, data['dialogue']);
    await add_option(data['choice1'], data['choice2'], data['choice3']);
    
    select_button_event(part);
    save_data_history(data);
}

function add_story(part, story) {
    return new Promise((resolve) => {
        const story_container = document.createElement('div');
        story_container.classList.add('story');
        part.appendChild(story_container);
        one_word_one_time(story_container, story).then(resolve);
    });
}

function add_dialogue(part, dialogue){
    return new Promise(async (resolve) => {
        for (const item of dialogue) {
            const dialogue_container = document.createElement('div');
            dialogue_container.classList.add('chat-bubble');
            const dialogue_text = item.name + ": " + item.content;
            part.appendChild(dialogue_container);
            await one_word_one_time(dialogue_container, dialogue_text);
        }
        resolve();
    });
}

function add_option(choice1, choice2, choice3){
    return new Promise((resolve) => {
        const option1_container = document.createElement('button');
        const option2_container = document.createElement('button');
        const option3_container = document.createElement('button');

        option1_container.id = 'option1';
        option2_container.id = 'option2';
        option3_container.id = 'option3';

        options.appendChild(option1_container);
        options.appendChild(option2_container);
        options.appendChild(option3_container);

        option1_container.textContent = choice1;
        option2_container.textContent = choice2;
        option3_container.textContent = choice3;

        resolve();
    });
}

function select_button_event(part){
    return new Promise((resolve) => {
        const buttons = document.querySelectorAll('.options button');
        buttons.forEach(button => {
            button.addEventListener('click', function() {
                const click_button = document.getElementById(this.id);
                const my_select_option = document.createElement('div');
                my_select_option.classList.add('my-chat-bubble');
                const select_button_text = click_button.textContent;
                my_select_option.textContent = select_button_text;
                part.appendChild(my_select_option);
                add_history(select_button_text);

                create_next_story();
                part_cnt += 1;

                options.innerHTML = ''; 
            });
        });
    });
};

function create_next_story(){
    console.log("data_history["+(part_cnt-1)+"]: " + JSON.stringify(data_history[part_cnt-1], null, 2));
    console.log("choice_history["+(part_cnt-1)+"]: " + JSON.stringify(choice_history[part_cnt-1], null, 2));
    fetch("/generate/story", {
        method: 'POST',
        body: JSON.stringify({
            //data: data_history[part_cnt-1],
            data: JSON.stringify(data_history[part_cnt-1]),
            choice: choice_history[part_cnt-1],
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        create_chat_div(data);
    })
    .catch(error => {
        console.error('error occur:', error);
    });
}

function one_word_one_time(div, story){
    return new Promise((resolve) => {
        let index = 0;
        const interval = 10;

        const intervalId = setInterval(() => {
            if (index < story.length) {
                div.textContent += story[index];
                index++;
            } else {
                clearInterval(intervalId);
                resolve();
            }
        }, interval);
    });
}

function add_history(select_button_text){
    const history_container = document.createElement('button');
    history_container.id = "history-" + part_cnt;
    history_container.setAttribute('data-value', part_cnt);
    history_container.classList.add('info-box');
    history.appendChild(history_container);
    history_container.textContent = select_button_text;

    save_choice_history(select_button_text);

    history_container.addEventListener('click', function() {
        const select_part_num = parseInt(this.getAttribute('data-value'));
        const prev_data = data_history[select_part_num];
        console.log("select_part_num: " + select_part_num+" part_cnt: " + part_cnt);

        document.getElementById('part-' + part_cnt).remove();
        do{
            part_cnt -= 1;
            const partElement = document.getElementById('part-' + (part_cnt));
            const historyElement = document.getElementById('history-' + (part_cnt));
            
            if(partElement){
                partElement.remove();
            }
            if(historyElement){
                historyElement.remove();
            }
            document.querySelectorAll('.options button').forEach(button => button.remove());
            delete_data_history(part_cnt);
            delete_choice_history(part_cnt);
        }
        while(part_cnt != select_part_num)
        
        create_chat_div(prev_data)
    });
}

function save_data_history(data){
    data_history[part_cnt] = data;
    console.log(data_history);
}

function delete_data_history(part_cnt){
    delete data_history[part_cnt];
    console.log(data_history);
}

function save_choice_history(choice){
    choice_history[part_cnt-1] = choice;
    console.log(choice_history);
}

function delete_choice_history(part_cnt){
    delete choice_history[part_cnt];
    console.log(choice_history);
}
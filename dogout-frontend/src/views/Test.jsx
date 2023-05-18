import React, { useState } from "react";

const Test = () => {
    const [players, setPlayers] = useState({
        firstPlayer: {
            firstCard: {
                value: 'ace',
                card: 'spades'
            },
            secondCard: {
                value: 'king',
                card: 'heart'
            }
        },
        secondPlayer: {
            firstCard: {
                value: 'ace',
                card: 'spades'
            },
            secondCard: {
                value: 'king',
                card: 'heart'
            }
        }
    })

    const handleClick = (event) => {
        const { name, value } = event.target;
        console.log(players[name][value].value);

        setPlayers(prevInfo => {
            return {
                ...prevInfo,
                [name]: {
                    ...prevInfo[name],
                    [value]: {
                        ...prevInfo[name][value],
                        value: 'two'
                    }
                }
            }
        })
    }

    return (
        <div style={{ color: "green", fontSize: "50px" }}>
            {players.firstPlayer.firstCard.value}
            {players.firstPlayer.secondCard.value}
            <button name="firstPlayer" value="firstCard" onClick={handleClick}>Klik</button>
            <button name="firstPlayer" value="secondCard" onClick={handleClick}>Klik</button>
        </div>
    )
}

export default Test;